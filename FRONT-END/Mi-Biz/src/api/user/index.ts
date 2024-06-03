import { fnAxios, miraeApi } from '../module/index';

const user = {
    miraeSSOLogin: (data: string) => {
        return miraeApi('GET', data);
    },
    formalLogin: (data: string) => {
        return fnAxios('POST', data, '');
    },
    loginUserBySso: (userId: number) => {
        return fnAxios('POST', '/api/common/login/sso', '', { userId });
    },
    loginUserByOtp: (userId: number, otp: number) => {
        return fnAxios('POST', '/api/common/login/otp', '', { userId, otp });
    }
};

export { user };
