package com.erp.board.service;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.erp.board.domain.Files;
import com.erp.board.mapper.FileMapper;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Value("${upload.path}")        // application.properties 에 설정한 업로드 경로 가져옴
    private String uploadPath;  

    /**
     * 파일 목록
     */
    @Override
    public List<Files> list() throws Exception {
        List<Files> fileList = fileMapper.list();
        return fileList;
    }

    /**
     * 파일 조회
     */
    @Override
    public Files select(int no) throws Exception {
        Files file = fileMapper.select(no);
        return file;
    }

    /**
     * 파일 등록
     */
    @Override
    public int insert(Files file) throws Exception {
        int result = fileMapper.insert(file);
        return result;
    }

    /**
     * 파일 수정
     */
    @Override
    public int update(Files file) throws Exception {
        int result = fileMapper.update(file);
        return result;
    }

    /**
     * 파일 삭제
     */
    @Override
    public int delete(int no) throws Exception {
        // 파일 정보 조회
        Files file = fileMapper.select(no);

        // DB 파일 정보 삭제
        int result = fileMapper.delete(no);

        // 파일 시스템의 파일 삭제
        if( result > 0 ) {
            String filePath = file.getFilePath();
            File deleteFile = new File(filePath);
            // 파일 존재 확인
            if( !deleteFile.exists() ) {
                return result;
            }
            // 파일 삭제
            if( deleteFile.delete() ) {
                log.info("파일이 정상적으로 삭제 되었습니다.");
                log.info("file : " + filePath);
            } else {
                log.info("파일 삭제에 실패하였습니다.");
            }
        }
        return result;
    }

    /**
     * 부모 테이블 기준, 파일 목록 조회
     */
    @Override
    public List<Files> listByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.listByParent(file);
        return fileList;
    }

    /**
     * 부모 테이블에 종속된 파일 목록 삭제
     */
    @Override
    public int deleteByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.listByParent(file);
        
        for (Files deleteFile : fileList) {
            int no = deleteFile.getNo();
            delete(no);
        }
        
        int result = fileMapper.deleteByParent(file);
        log.info(result + "개의 파일을 삭제하였습니다.");
        return result;
    }

    /**
     * 파일 업로드
     */
    @Override
    public boolean upload(Files file) throws Exception {
        log.info("file : " + file);

        MultipartFile mf = file.getFile();
        // 파일 정보 : 원본 파일명, 파일 용량, 파일 데이터
        String originName = mf.getOriginalFilename();
        long fileSize = mf.getSize();
        byte[] fileData = mf.getBytes();

        log.info("원본 파일명 : " + originName);
        log.info("파일 용량 : " + fileSize);
        log.info("파일 데이터 : " + fileData);

        // ⭐ 파일 업로드
        // - 파일 시스템의 해당 파일을 복사
        // - 파일의 정보를 DB에 등록
        
        // ✅ 업로드 경로   - application.properties ( upload.path )
        // ✅ 파일명        
        // - 파일명 중복 방지를 위해 UID_파일명.xxx 형식으로 지정
        // - 업로드 파일명 : UID_원본파일명.xxx
        String fileName = UUID.randomUUID().toString() + "_" + originName;
        File uploadFile = new File(uploadPath, fileName);

        // ⬆ 파일 업로드                
        FileCopyUtils.copy(fileData, uploadFile);

        // 파일 정보 등록
        file.setFileName(fileName);
        file.setOriginName(originName);
        // filePath C:/upload/UID_원본파일명.xxx
        String filePath = uploadPath + "/" + fileName; 
        file.setFilePath(filePath);
        file.setFileSize(fileSize);
        // ⭐ 넘겨받을 때 세팅함.
        // file.setFileCode(0);
        fileMapper.insert(file);

        return true;
    }

    //@Override
    // public Files download(int no) throws Exception {
    //     Files file = fileMapper.select(no);

    //     // 다운로드 시, 추가 작업
    //     // ...

    //     return file;
    // }
    
    @Override
    public int download(int no, HttpServletResponse response) throws Exception {
        // result 
        // 0 : 파일 다운로드 처리 실패
        // 1 : 파일 다운로드 성공
        Files file = fileMapper.select(no);

        if( file == null ) {
            // BAD_REQUEST : 400, 클라이언트의 요청이 잘못되었음을 알려주는 상태코드
            // response.setStatus(response.SC_BAD_REQUEST);
            return 0;
        }

        String filePath = file.getFilePath();       // 파일 경로
        String fileName = file.getFileName();       // 파일 이름
        fileName = URLEncoder.encode(fileName, "UTF-8");
        
        // 다운로드 응답을 위한 헤더 세팅
        // - ContentType            : application/octet-stream
        // - Content-Disposition    : attachment, filename="파일명.확장자"
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // 파일 다운로드
        // - 파일 입력
        File downloadFile = new File(filePath);
        FileInputStream fis = new FileInputStream(downloadFile);

        // - 파일 출력
        ServletOutputStream sos = response.getOutputStream();

        // 다운로드
        FileCopyUtils.copy(fis, sos);

        // byte[] buffer = new byte[1024];             // 1024bytes = 1KB 단위 버퍼
        // int data;
        // while( (data = fis.read(buffer)) != -1 ) {  // 1KB 씩 파일입력
        //     sos.write(buffer, 0, data);         // 1KB 씩 파일출력
        // }
        fis.close();
        sos.close();

        return 1;
     }
}