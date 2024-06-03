import Axios, { AxiosRequestConfig, Method } from 'axios';
import { useGlobalUiStore } from '@/store/global-ui';
let uiController: any = null;

// api 공통 함수
// 2023-07-24 현재
// post - header: application/json 기본값으로 설정
// 추가 옵션은 차후 개발예정

export const miraeApi = async (method: any, urls: any) => {
    return await Axios(axiosMiraeSSOConfig<any>(method, urls));
};

export const fnAxios = async (method: any, urls: any, type: any, data?: any) => {
    let oResponse: any = null;
    try {
        oResponse = await Axios(axiosConfig<any>(method, urls, data));

        if (!uiController) {
            uiController = useGlobalUiStore();
        }
        console.log('oResponse', oResponse);

        if (oResponse.status === 401) {
            console.log('Unauthorized', oResponse);
            oResponse = '401';
        } else if (oResponse.status === 403) {
            console.log('Forbidden', oResponse);
            oResponse = '403';
        } else if (oResponse.status === 404) {
            console.log('Not Found', oResponse);
            oResponse = '404';
        } else if (oResponse.headers === undefined) {
            console.log('axios header is null!!!!', oResponse);
            oResponse = '9999';
        }
    } catch (err: any) {
        console.log('axios error > ', err);
        return { err };
        // TODO 로그인 세션없음 Case 판별법 검증 필요함
    }

    return oResponse;
};

// 통합인증 api
// url은 고정이며 method역시 고정

const axiosMiraeSSOConfig = <Res>(method: Method, urls: string, data?: any) => {
    const config: AxiosRequestConfig<Res> = {
        method,
        url: 'https://localhost:40443/' + urls,
        timeout: 60000,
        data
    };
    return config;
};

// axios 설정 공통 변수
// 2023-07-24 기준 header 기본값 및 post 설정
// get, put .... 추가 설정 개발 예정
// header 옵션 추가 개발

import { getDomain } from '@/composables/useGlobal';

const axiosConfig = <Res>(method: Method, urls: string, data?: any) => {
    // const sConnectUrl = import.meta.env.VITE_LOCAL_URI;
    const sConnectUrl = getDomain();
    const oDefHeader: any = {
        Accept: 'application/json; charset=UTF-8',
        'Content-Type': 'application/json'
    };
    const config: AxiosRequestConfig<Res> = {
        headers: oDefHeader,
        method,
        timeout: 120 * 1000,
        url: sConnectUrl + urls,
        data
    };
    return config;
};

// 모바일
export const axiosBaseConfig = <Res>(
    method: Method,
    url: string,
    queryString?: { [key: string]: string },
    data?: any,
    header?: any,
    responseType?: any
) => {
    const sConnectUrl = getDomain();
    let config: AxiosRequestConfig<Res> = {
        method,
        url: sConnectUrl + url,
        data
    };
    // querystring 붙이기
    if (queryString) {
        config.url = addQueryString(url, queryString);
    }
    if (header !== undefined && header !== null && header === 'multipart') {
        config.headers = { 'Content-Type': 'multipart/form-data' };
    }

    if (responseType !== undefined && responseType !== null) {
        config.responseType = 'blob';
    }

    return config;
};

export const addQueryString = (url: string, queryStringObj: { [key: string]: string }) => {
    let result = url;
    for (const [key, value] of Object.entries(queryStringObj)) {
        if (value) {
            result = updateQueryString(key, value, url);
        }
    }
    return result;
};

export const updateQueryString = (key: string, value: string, url: string) => {
    if (!url) url = window.location.href;
    let re = new RegExp('([?&])' + key + '=.*?(&|#|$)(.*)', 'gi'),
        hash;

    if (re.test(url)) {
        if (typeof value !== 'undefined' && value !== null) {
            return url.replace(re, '$1' + key + '=' + value + '$2$3');
        } else {
            hash = url.split('#');
            url = hash[0].replace(re, '$1$3').replace(/(&|\?)$/, '');
            if (typeof hash[1] !== 'undefined' && hash[1] !== null) {
                url += '#' + hash[1];
            }
            return url;
        }
    } else {
        if (typeof value !== 'undefined' && value !== null) {
            let separator = url.indexOf('?') !== -1 ? '&' : '?';
            hash = url.split('#');
            url = hash[0] + separator + key + '=' + value;
            if (typeof hash[1] !== 'undefined' && hash[1] !== null) {
                url += '#' + hash[1];
            }
            return url;
        } else {
            return url;
        }
    }
};
