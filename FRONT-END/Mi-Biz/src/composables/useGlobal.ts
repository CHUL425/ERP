import moment from 'moment';
import api from '@/api';
// Formatter Start
/**
 *
 * @param paramValue 원본값
 * @param changePattenNum 0 : 문자로 변환, 1 : replace(정규식), 2: replaceAll(변경문자), 3: 전위 문자열 합치기, 4: 후위 문자열 합치기, 5: 전후 문자열 합치기
 * @param frastPatten 전위 패턴
 * @param lastPatten 전후 문자 변경 및 replace 변경시에만 사용
 *
 */

export function formatMoney(money: string, noUnit: boolean = false) {
    let formatted = money?.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') || '0';
    if (money === '') {
        formatted = '0';
    }

    if (noUnit) {
        return formatted;
    } else {
        return formatted + ' 원';
    }

    return (money?.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') || '0') + ' 원';
}

export function formatDate(date: any) {
    const newDate = moment(date).format('YYYY-MM-DD');
    return newDate === 'Invalid date' ? '' : newDate;
}

export function formatServerDate(date: any) {
    return moment(date).format('YYYYMMDD');
}

export const getDomain = () => {
    const domain = location.host;
    if (domain.includes('biz.miraeassetsecurities')) {
        return 'https://biz.miraeassetsecurities.com:10443/';
    } else if (domain.includes('biztest.miraeassetsecurities')) {
        return 'https://biztest.miraeassetsecurities.com:10443/';
    } else if (domain.includes('mobile.miraeassetsecurities')) {
        return 'http://bizdev.miraeassetsecurities.com/';
    } else {
        return 'https://bizdev.miraeassetsecurities.com/';
    }
};

import axios from 'axios';
const apiUrl = getDomain();
export const fileController = {
    async download(fileNo: string, fileDlNo: string) {
        return axios.post(`${apiUrl}api/common/file/downFile`, { fileNo, fileDlNo }, { responseType: 'arraybuffer' }).then((res) => {
            console.log(res);
            const blob = makeJsonToFile(res.data);
            const fileName = getFileName(res);

            const link = document.createElement('a');
            link.style.display = 'none';

            link.href = URL.createObjectURL(blob);
            link.download = fileName;
            link.click();
        });

        function getFileName(res: any) {
            let fileName = res.headers['content-disposition'];
            if (!fileName) {
                return;
            }
            fileName = decodeURIComponent(fileName.substr(fileName.indexOf('fileName="') + 10).slice(0, -1));
            return fileName;
        }

        function makeJsonToFile(text: string) {
            const buffer = text;
            return new Blob([buffer], { type: 'appication/octer-stream' });
        }
    }
};

export const taskFilesViewer = async (fileKey: any, userId: any) => {
    let result: any = {
        resultCd: '9999',
        resultMsg: '알수없는 이유로 연결에 실패하였습니다',
        format: '',
        key: '',
        fileName: ''
    };
    try {
        if (fileKey !== undefined && fileKey !== null && userId !== undefined && userId !== null) {
            const res = await api.common.filesViewer({ fileKey, userId });
            if (res !== undefined && res !== null && res.data !== undefined && res.data !== null) {
                result.format = res.data.format !== undefined && res.data.format !== null ? res.data.format : 'img';
                result.key = res.data.key;
                result.fileName = res.data.fileName;
                result.resultCd = '0000';
            }
        } else {
            result.resultCd = '8888';
            result.resultMsg = '해당 파일의 정보가 없습니다.';
        }
    } catch (e: any) {
        console.log('e', e.response.data);
        if (e.response.data.status === 404) {
            result.resultCd = '404';
            result.resultMsg = e.response.data.detail;
        } else if (e.response.data.status === 400) {
            result.resultCd = '400';
            result.resultMsg = e.response.data.detail;
        } else if (e.response.data.status === 500) {
            result.resultCd = '500';
            result.resultMsg = e.response.data.detail;
        } else {
            result.resultCd = '9999';
            result.resultMsg = e.response;
        }
    }

    return result;
};

export const filesDownload = async (fileSrc: any, userId: any) => {
    let result: any = {
        resultCd: '8888',
        resultMsg: '알수없는 이유로 연결에 실패하였습니다',
        resultList: []
    };
    try {
        if (fileSrc !== undefined && fileSrc !== null) {
            const res = await api.common.filesDownload(fileSrc.fileNo, userId);
            console.log(fileSrc);
            if (res !== undefined && res !== null && res.data !== undefined && res.data !== null) {
                const url = window.URL.createObjectURL(new Blob([res.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', fileSrc.fileNm);
                link.style.cssText = 'display:none';
                document.body.appendChild(link);
                link.click();
                link.remove();
                window.URL.revokeObjectURL(url);
                result.resultCd = '0000';
            }
        } else {
            result.resultMsg = '잘못된 접근입니다';
        }
    } catch (e: any) {
        console.log('e', e.response.data);
        if (e.response.data.status === 404) {
            result.resultCd = '404';
            result.resultMsg = e.response.data.detail;
        } else if (e.response.data.status === 400) {
            result.resultCd = '400';
            result.resultMsg = e.response.data.detail;
        } else if (e.response.data.status === 500) {
            result.resultCd = '500';
            result.resultMsg = e.response.data.detail;
        } else {
            result.resultCd = '9999';
            result.resultMsg = e.response;
        }
    }

    return result;
};
