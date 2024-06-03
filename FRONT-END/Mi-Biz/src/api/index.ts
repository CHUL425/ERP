import { user } from '../api/user';
import { mobile } from '../api/mobile';
import { common } from '../api/common';
// 각각의 필요한 페이지에 맞는 api모듈화를 진행
const api = {
    mobile,
    user,
    common
};

export default api;
