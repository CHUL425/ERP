export const urls = {
    getMenuList: `api/common/login/user-menu`,
    commonSelList: `api/common/code/gacode01/selList`,
    commonATcodeList: `api/common/code/atcode01/selList`,
    getGroupList: `api/common/code/teamcode00/selList`,
    getUserList: `api/common/basic/user00/selList`,
    rentalApply: `api/main/rqur1000u0/reqRegi`,
    getCmdsList: `api/common/cmds/cmds1000v0/sel00`,
    getCmps1000List: `api/common/cmps/cmps1000v0/sel01`,
    getCmbs1000List: `api/common/cmbs/cmbs1000v0/sel00`,
    getAddrList: `api/common/basic/org00/selList`,
    filesViewer: (fileKey: string, userId: string) => `/api/common/file/vwKey?nm=${fileKey}&id=${userId}`,
    filesDownload: (fileKey: string, userId: string) => `/api/common/file/dn?nm=${fileKey}&id=${userId}`
};
