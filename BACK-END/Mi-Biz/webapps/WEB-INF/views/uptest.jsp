<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	    <meta charset="utf-8"/>
        <script type="application/javascript">
            /*
            function fnFileDown(seq){
                var xhr = new XMLHttpRequest();
                xhr.open("POST","/api/common/file/dn",true);
                xhr.responseType = "blob";
                xhr.setRequestHeader("Content-type","application/json");
                xhr.onload = function(){
                    const file = xhr.response;
                    if(file){
                        var blob = new Blob([file], { type : "application/octetstream"});
                        var link = document.createElement("a");
                        link.href = window.URL.createObjectURL(blob);
                        link.download="aaaaa.json";
                        link.click();
                    }
                }
                xhr.send(JSON.stringify({test:"test", seq:null}));
            }
            */
        </script>
    </head>
    <body>
        <div>
            <a href="javascript:history.back();">뒤로 가기 테스트 용</a>
        </div>
        <br /><br />

        <form name="frm" method="post" enctype="multipart/form-data" action="/api/common/file/up" accept-charset="UTF-8">
            <input type="file" name="mpFile" /> <br />
            <input type="file" name="mpFile" /> <br />
            <input type="file" name="mpFile1" /> <br />
            <input type="file" name="mpFile2" /> <br />
            <br />
            <input type="submit" value="[ 업로드 시작 ]" /> <br />
            <br />
            <br />
            <br />
            <div>TSK_ID : <input type="text" name="tskId" value="T000000126" /></div>

            <input type="text" name="txt2" value="" /><br />
            <input type="text" name="txt3" value="" /><br />
            <input type="hidden" name="hid1" value="hid1" />
            <input type="hidden" name="hid2" value="hid2" />
        </form>

        <br />
        <hr style="border: 2px solid #000000" />
        <br />
        <div><b>ㅇ TEST2 서버 + 태블릿 에서 뷰어 링크 테스트 시 사용 (링크 만료 될 수 있음)</b></div>
        <br />
        <a href="https://fileviewer.miraeassetsecurities.com/SynapDocViewServer/viewer/doc.html?key=ec2fa7ecad4045b6861f5e12ee588d0a&convType=img&convLocale=ko_KR&contextPath=/SynapDocViewServer" target="_blank">뷰어 태블릿 테스트 용도 - https</a>
        <br />
        <br />
        <a href="http://fileviewer.miraeassetsecurities.com/SynapDocViewServer/viewer/doc.html?key=ec2fa7ecad4045b6861f5e12ee588d0a&convType=img&convLocale=ko_KR&contextPath=/SynapDocViewServer" target="_blank">뷰어 태블릿 테스트 용도 - http</a>
        <br />
        <br />
        <a href="https://10.100.55.108:8080/SynapDocViewServer/viewer/doc.html?key=ec2fa7ecad4045b6861f5e12ee588d0a&convType=img&convLocale=ko_KR&contextPath=/SynapDocViewServer" target="_blank">뷰어 태블릿 테스트 용도 - IP - https</a>
        <br />
        <br />
        <a href="http://10.100.55.108:8080/SynapDocViewServer/viewer/doc.html?key=ec2fa7ecad4045b6861f5e12ee588d0a&convType=img&convLocale=ko_KR&contextPath=/SynapDocViewServer" target="_blank">뷰어 태블릿 테스트 용도 - IP - http</a>
        <br />
        <br />

        <br />
        <hr style="border: 2px solid #000000" />
        <br />
        <div><b>ㅇ 파일 다운로드 테스트 용 링크 (삭제 예정)</b></div>
        <br />
        <a href="/api/common/file/dn?nm=F02A5AF8201600E2E0530A10692148CE" target="_blank">파일 다운로드 샘플_DEV2_json</a>
        <br />
        <br />
        <a href="/api/common/file/dn?nm=F02A5AF8201700E2E0530A10692148CE" target="_blank">파일 다운로드 샘플_DEV2_bmp</a>
        <br />
        <br />
        <a href="/api/common/file/vwKey?nm=F02A5AF8201700E2E0530A10692148CE&id=3359722" target="_blank">뷰어 Key 샘플_DEV2_로그인 정보와 ID 파라미터가 다른 경우_3359722</a>
        <br />
        <br />
        <a href="/api/common/file/vwKey?nm=F02A5AF8201700E2E0530A10692148CE&id=3357223" target="_blank">뷰어 Key 샘플_DEV2_로그인 정보와 ID 파라미터가 다른 경우_3357223</a>
        <br />
        <br />
        <br />
        <a href="/api/common/file/dn?nm=F037CDC9CF7900BCE0530ADCC82674C1&id=3359722" target="_blank">파일 다운로드 샘플_검증계용</a>
        <br />
        <br />
        <a href="/api/common/file/vwKey?nm=F037CDC9CF7900BCE0530ADCC82674C1&id=3359722" target="_blank">뷰어 Key 샘플_검증계용</a>
        <br />
        <br />
        <hr style="border: 2px solid #000000" />
        <br />
        <div><b>ㅇ 삭제 예정</b></div>
        <br />
        <a href="/api/common/file/dn?nm=F25BABD5E8370152E0530ADCC8268F2D" target="_blank">파일 다운로드 샘플_검증계용_TXT</a>
        <br />
        <br />
        <a href="/api/common/file/vwKey?nm=F25BABD5E8370152E0530ADCC8268F2D&id=3359722" target="_blank">뷰어 Key 샘플_검증계용_PDF_3359722</a>
        <br />
        <br />
        <a href="/api/common/file/vwKey?nm=F25BABD5E8370152E0530ADCC8268F2D&id=3357223" target="_blank">뷰어 Key 샘플_검증계용_PDF_3357223</a>
        <br />
        <br />
        <hr style="border: 2px solid #000000" />
        <br />
        <div><b>ㅇ 엑셀 다운로드 테스트 용 링크 (삭제 예정)</b></div>
        <br />
        <div><b>- 1. 렌탈관리 정수기 삭제 예정</b></div>
        <br />
        <form name="frm" method="post" enctype="multipart/form-data" action="/api/garm/garm2000v0/excel">
        	<input type="text" name="exccYm" value="202306" hidden="true"/>
	        <input type="submit" value="엑셀 다운로드" /> <br />
        </Form>
        <br />
        <div><b>- 2. 공사신청목록 삭제 예정</b></div>
        <br />
        <form name="frm" method="post" enctype="multipart/form-data" action="/api/rqcr/rqcr1000u0/excel">
        	<input type="text" name=qryStrtDt value="20230701" hidden="true"/>
        	<input type="text" name=qryEndDt  value="20230712" hidden="true"/>
	        <input type="submit" value="엑셀 다운로드" /> <br />
        </Form>
		<br />
		<br />
        <%--<form name="frm2" method="post" enctype="application/x-www-form-urlencoded" action="/api/common/file/dn">
            <input type="submit" value="디폴트 파일 다운로드" /> <br />
        </form>

        <br />
        <br />
        <br />
        <form name="frm3" method="post" enctype="application/x-www-form-urlencoded" action="/api/common/file/dn">
            <input type="text" name="seq" value="1" /> <br />
            <input type="submit" value="n번 파일 다운로드" /> <br />
        </form>--%>

    </body>
</html> 



