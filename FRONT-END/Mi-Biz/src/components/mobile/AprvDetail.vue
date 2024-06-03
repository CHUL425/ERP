<script setup lang="ts">
import { watch, ref, onMounted } from 'vue';
import api from '@/api';
import docPopup from '@/components/mobile/view/docPopup.vue';
import BaseLoading from '@/components/mobile/BaseLoading.vue';

const props = defineProps({
    data: {
        type: Object
    }
});

const emit = defineEmits(['onChange', 'onClose']);

const detailData = ref(props.data);
const data: any = ref({});
const imgData: any = ref([]);
const reason = ref('');
const showAlert = ref(false);
const aprvRsnCn = ref();
watch(
    () => props.data,
    (newVal) => {
        if (newVal) {
            detailData.value = newVal;
        }
    }
);

onMounted(() => {
    searchData();
    aprvRsnCn.value = null;
});

async function searchData() {
    const res: any = await api.mobile.selectDetailList({ rctNo: detailData.value?.rctNo });
    if (detailData?.value?.state === 'aprvl') {
        reason.value = '반려시 반려사유 작성은 필수예요.';
    } else {
        reason.value = res.data.aprvRsnCn;
    }

    data.value = res.data;

    if (res.data.gridGA01N504.length !== 0) {
        imgData.value = res.data.gridGA01N504;

        for (let i = 0; i < res?.data?.gridGA01N504?.length; i++) {
            for (let j = 0; j < res?.data?.gridGA01N504[i]?.gridGA09N411?.length; j++) {
                const fileName = res.data.gridGA01N504[i].gridGA09N411[j].fileNm;
                const file = fileName.split('.');

                res.data.gridGA01N504[i].gridGA09N411[j].fileName = file[0];
                res.data.gridGA01N504[i].gridGA09N411[j].fileExtension = file[1];
            }
        }
    }
}

import moment from 'moment';
import $ from 'jquery';
import { getDomain } from '@/composables/useGlobal';
import router from '@/router';
import { useRoute } from 'vue-router';

const route = useRoute();
const vueUrl = ref('');
const filePath: any = ref('');
const fileNm = ref();
const url: any = ref('');
const sConnectUrl: any = ref();
// 문서뷰어
async function callSynapDocumentViewer(qry_type: any, file: any) {
    const param: any = {
        fileNo: file.fileNo,
        fileDlNo: file.fileDlNo
    };
    const res: any = await api.mobile.selectFilePath(param);
    if (res.status === 200) {
        fileNm.value = res.data;
        let d = new Date();
        let second = 1000 * 60;
        sConnectUrl.value = getDomain();

        if (sConnectUrl.value === 'https://bizdev.miraeassetsecurities.com/') {
            url.value = 'https://docvwdp.miraeassetsecurities.com:443/SynapDocViewServer/'; // 외부망 개발
        } else if (sConnectUrl.value === 'https://biztest.miraeassetsecurities.com:10443/') {
            url.value = 'https://docvwdp.miraeassetsecurities.com:443/SynapDocViewServer/';
        } else if (sConnectUrl.value === 'https://biz.miraeassetsecurities.com:10443/') {
            url.value = 'https://docvwp.miraeassetsecurities.com:443/SynapDocViewServer/';
        } else {
            url.value = 'https://docvwdev.miraeassetsecurities.com:8443/SynapDocViewServer/'; // 외부망 운영
        }

        var convertType = '0';
        var fileType = 'URL';
        var fid =
            'MI_' +
            moment().format('YYYYMMDD').toString() +
            '_' +
            moment().format('YYYYMMDDhhmmss').toString() +
            moment(d.getTime() + second)
                .format('YYYYMMDDhhmmss')
                .toString()
                .substring(0, 2);

        // filePath 설정
        if (sConnectUrl.value.includes('biz.miraeassetsecurities')) {
            filePath.value = `https://biz.miraeassetsecurities.com//api/common/downFile?fileNm=${fileNm.value}`;
        } else if (sConnectUrl.value.includes('biztest.miraeassetsecurities')) {
            filePath.value = `https://biztest.miraeassetsecurities.com//api/common/downFile?fileNm=${fileNm.value}`;
        } else {
            filePath.value = `http://bizdev.miraeassetsecurities.com//api/common/downFile?fileNm=${fileNm.value}`;
        }

        var vurl = url.value;

        var params = {
            filePath: filePath.value, // 파일 주소
            fileType: fileType,
            fid: fid, // 파일
            convertType: convertType,
            urlEncoding: 'UTF-8'
            //pageEnd: 1
        };

        $.ajax({
            type: 'POST',
            url: vurl + 'jobJson',
            data: params,
            contentType: 'application/x-www-form-urlencoded',
            dataType: 'json',
            cache: false,
            async: false,
            xhrFields: { withCredentials: true },
            error: function (request: any, status: any, error: any) {
                console.log('error' + request.responseJSON);
            },
            success: function (data: any) {
                if (data != null) {
                    var viewUrl =
                        url.value + `viewer/doc.html?key=${data.key}&convType=img&convLocale=ko_KR&contextPath=/SynapDocViewServer`;
                    vueUrl.value = viewUrl;

                    if (viewUrl) {
                        docPopOpen(viewUrl);
                    }
                }
            }
        });
    }
}

const isLoadingOpen = ref(false);
const description = ref('');
async function sendConfirm(state: any) {
    if (detailData?.value?.aprvRnk === '2' || detailData?.value?.aprvOrzCd === 'J01001') {
        description.value = '모바일 승인/반려처리 불가해요. <br/> PC [Mi-support]에서 승인/반려처리 해주세요.';
        showAlert.value = true;
    } else {
        if (state === '승인') {
            const param: any = {
                aprvEpno: '',
                grid11: [
                    {
                        rctNo: detailData?.value?.rctNo,
                        aprvWrrptMtNo: detailData?.value?.aprvWrrptMtNo,
                        aprvRnk: detailData?.value?.aprvRnk,
                        aprvDlRnk: detailData?.value?.aprvRnk,
                        aprvPcd: detailData?.value?.aprvPcd,
                        rqsTtlNm: detailData?.value?.rqsTtlNm,
                        aprvRsnCn: aprvRsnCn.value
                    }
                ]
            };
            isLoadingOpen.value = true;
            const res = await api.mobile.getAprvList(param);
            if (res?.status === 200) {
                isLoadingOpen.value = false;
                emit('onChange');
            }
        } else if (state === '반려') {
            description.value = '반려사유를 작성해주세요.';
            if (aprvRsnCn.value === '' || aprvRsnCn.value === null) {
                showAlert.value = true;
            } else {
                const param = {
                    rctNo: detailData?.value?.rctNo,
                    aprvWrrptMtNo: detailData?.value?.aprvWrrptMtNo,
                    aprvRnk: detailData?.value?.aprvRnk,
                    aprvDlRnk: detailData?.value?.aprvRnk,
                    aprvPcd: detailData?.value?.aprvPcd,
                    rqsTtlNm: detailData?.value?.rqsTtlNm,
                    aprvWrrptOrzCd: '',
                    aprvRtrnTcd: '2',
                    aprvRsnCn: aprvRsnCn.value
                };
                isLoadingOpen.value = true;
                const res = await api.mobile.getRtrn(param);
                if (res.status === 200) {
                    isLoadingOpen.value = false;
                    emit('onChange');
                }
            }
        } else if (state === '확인') {
            const param = {
                gridGA09N607: [
                    {
                        aprvWrrptMtNo: detailData?.value?.aprvWrrptMtNo,
                        aprvRnk: detailData?.value?.aprvRnk,
                        aprvDlRnk: detailData?.value?.aprvRnk
                    }
                ]
            };
            isLoadingOpen.value = true;
            const res: any = await api.mobile.updateCfmt(param);
            if (res.status === 200) {
                isLoadingOpen.value = false;
                emit('onChange');
            }
        } else {
            emit('onClose', detailData?.value?.rctNo);
        }
    }
}

function clickConfirm() {
    showAlert.value = false;
}

const docPopisOpen = ref();
const link: any = ref('');

function docPopOpen(url: any) {
    link.value = url;
    docPopisOpen.value = true;
}

function docPopClose() {
    docPopisOpen.value = false;
}

const baseUrl: any = ref('');
function formatDraftUrl(draftNo: string) {
    baseUrl.value =
        'https://mgwn.miraeasset.com/WebSite/MobileNew/Approval/ApprovalView.aspx?system=Approval&alias=P.COMPLETE.COMPLETE&mode=COMPLETE&gloct=COMPLETE&archived=false&bstored=false&MCFN_PopupName=mPop_ApprovalView&MCFN_OpenerName=&piid=';

    if (draftNo?.length === 32) {
        return `${baseUrl.value}${draftNo.slice(0, 8)}-${draftNo.slice(8, 12)}-${draftNo.slice(12, 16)}-${draftNo.slice(
            16,
            20
        )}-${draftNo.slice(20, 32)}`;
    }
}
</script>

 
<template>
    <tr v-if="props?.data?.isActive">
        <td colspan="3" class="td_container">
            <template v-if="data?.gridGA01N504?.length > 0">
                <h1>▣ 인감날인</h1>
                <p v-for="(item, idx) in data?.gridGA01N504" :key="idx" :class="{ line: idx !== data?.gridGA01N504?.length - 1 }">
                    <span v-if="item.rqsRsnCn !== '사용인감계'">[일반]&ensp;{{ item.rqsRsnCn }}<br /></span>
                    <span v-else>[사용인감계]<br /></span>
                    <span>[제출처]&ensp;{{ item.smitpCn }}<br /></span>
                    <span>[유형]&ensp;{{ item.salMtNm }}<br /></span>
                    <span>[날인수]&ensp;{{ item.rqsQ }}<br /></span>
                    <template v-if="imgData.length !== 0 && imgData[0].gridGA09N411">
                        <span class="file_list" style="display: flex; flex-wrap: wrap; width: 100%; margin-bottom: 3px; margin-top: 3px"
                            ><span>[첨부파일]</span>
                            <div
                                class="attafile_item"
                                v-for="(element, idx) in item.gridGA09N411"
                                :key="idx"
                                @click="callSynapDocumentViewer('webView', element)"
                            >
                                <div class="file_info">
                                    <span class="filename">{{ element.fileName }}</span>
                                    <span class="ext">&ensp;.{{ element.fileExtension }}</span>
                                </div>
                            </div>
                        </span>
                    </template>
                </p>
                <br />
            </template>

            <template v-if="data?.gridGA01N505?.length > 0">
                <h1>▣ 증명서신청</h1>
                <p v-for="(item, idx) in data?.gridGA01N505" :key="idx" :class="{ line: idx !== data?.gridGA01N505?.length - 1 }">
                    <span>[증명서]<br /></span>
                    <span>[유형]&ensp;{{ item.salMtNm }}<br /></span>
                    <span v-if="item.sealCtfwTcd === '10'">[수량]&ensp;{{ item.sealDocCnt }}<br /></span>
                    <span v-else>[수량]&ensp;{{ item.certDocCnt }}<br /></span>
                    <span>[제출처]&ensp;{{ item.smitpCn }}<br /></span>
                    <span>[제출용도]&ensp;{{ item.smitUsgeCn }}<br /></span>
                </p>
                <br />
            </template>

            <template v-if="data?.gridGA01N109?.length > 0">
                <h1>▣ 연관문서</h1>
                <p>
                    <span
                        style="cursor: pointer; font-weight: bold; display: flex; flex-wrap: wrap; margin-left: 3px"
                        v-for="(item, idx) in data.gridGA01N109"
                        :key="idx"
                    >
                        <div class="doc_item">
                            <a :href="formatDraftUrl(item.drftDocNo)" target="_blank" style="color: black; font-weight: 500">{{
                                item.drftDocTtlNm
                            }}</a>
                        </div>
                    </span>
                </p>
                <br />
            </template>

            <textarea
                class="text_area"
                :class="{ readonly: detailData?.state !== 'aprvl' || detailData?.aprvRnk === '2' || detailData?.aprvOrzCd === 'J01001' }"
                v-if="detailData?.state !== 'preRfr'"
                :placeholder="reason"
                :readonly="detailData?.state !== 'aprvl' || detailData?.aprvRnk === '2' || detailData?.aprvOrzCd === 'J01001'"
                v-model="aprvRsnCn"
            ></textarea>
            <div class="td_btn_area">
                <template v-if="detailData?.state === 'aprvl'">
                    <button class="btn_approval" @click="sendConfirm('승인')">승인</button>
                    <button class="btn_reject ml8" @click="sendConfirm('반려')">반려</button>
                </template>
                <template v-else-if="detailData?.state === 'preRfr'">
                    <button class="btn_approval" @click="sendConfirm('확인')">확인</button>
                </template>
                <template v-else>
                    <button class="btn_approval" @click="sendConfirm('닫기')">닫기</button>
                </template>
            </div>
        </td>
    </tr>
    <div v-if="showAlert" class="popup_container_vis">
        <div class="popup_box">
            <div class="box_wrapper">
                <div class="desc_box" v-html="description"></div>
                <div class="button_type_box">
                    <div class="confirm_box" @click="clickConfirm">확인</div>
                </div>
            </div>
        </div>
    </div>

    <docPopup v-if="docPopisOpen" :data="link" @close="docPopClose" />
    <BaseLoading v-if="isLoadingOpen" v-model="isLoadingOpen" />
</template>

<style scoped>
.td_container {
    background: #f8f8f8;
    padding: 24px 16px;

    h1 {
        font-size: 16px;
        font-weight: 700;
        color: #333333;
        padding-bottom: 5px;
    }

    h2 {
        margin: 16px 0;
        font-size: 14px;
    }

    h3 {
        margin-top: 16px;
        font-size: 12px;
    }

    p {
        line-height: 24px;
        padding: 5px;
    }

    .line {
        border-bottom: 1.5px dashed #b5b5b5;
    }

    .td_btn_area {
        margin-top: 24px;
        width: 100%;
        display: flex;
        justify-content: center;

        button {
            display: inline-block;
            width: 68px;
            height: 28px;
            border: 0;
            color: #fff;
        }

        .btn_approval {
            background: #f58220;
            border-radius: 4px;
            margin-right: 8px;
        }

        .btn_reject {
            background: #999999;
            border-radius: 4px;
        }
    }
}
.file_list {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    margin-bottom: 3px;
    margin-top: 3px;
}
.attafile_item {
    font-size: 13px;
    background-color: #d3d3d3;
    border-radius: 100px;
    padding: 3px;
    margin: 0 7px 7px 10px;
    max-width: 205px;
    min-width: 205px;
    height: 30px;
    padding-bottom: 1px;
    display: flex;
    padding-left: 11px;
    padding-right: 15px;
    text-overflow: ellipsis;
    overflow: hidden;
}

.file_info {
    text-overflow: ellipsis;
    overflow: hidden;
    display: flex;
    min-width: 185px;
    max-width: 185px;
}

.file_info .filename {
    display: block;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    border-right: none;
    padding-left: 0;
}

.file_info .ext {
    flex-shrink: 0;
    margin-left: -4px;
}

.doc_item {
    background-color: #d9d9d9;
    border-radius: 100px;
    padding: 3px;
    margin: 0 7px 7px 10px;
    height: 30px;
    padding-bottom: 1px;
    display: flex;
    padding-left: 11px;
    padding-right: 15px;
    text-overflow: ellipsis;
    overflow: hidden;
    font-size: 13px;
}

.text_area {
    display: flex;
    align-items: center;
    border: 1px solid #d4d4d4;
    border-radius: 4px;
    height: 80px;
    width: 100%;
    padding: 10px;
}

.readonly {
    background-color: #f1f1f1;
}

.doc_title {
    color: #000;
    display: block;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}

.popup_container_vis {
    position: fixed;
    background: transparent;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 99998;
    transition: 0.1s;
    display: flex;
    justify-content: center;
    align-items: center;
    background: rgba(46, 46, 46, 0.5);

    .popup_box {
        width: 380px;
        border-radius: 30px;
        text-align: left;
        opacity: 1;
        transition: 0.1s;
    }

    .box_wrapper {
        position: relative;
        top: 0;
        width: 100%;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.16);

        .title_box {
            display: flex;
            height: 30px;
            line-height: 30px;
            justify-content: center;
            align-items: center;
            background-color: var(--main-color-100);
            color: white;
            font-size: 18px;
        }

        .desc_box {
            display: flex;
            flex-direction: column;
            min-height: 150px;
            justify-content: center;
            align-items: center;
            color: var(--text-color-100);
            font-size: 18px;
            padding: 12px;
        }

        .confirm_button {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 0 0 157px;
            color: #fff;
            font-size: 16px;
            border-radius: 5px;
            height: 32px;
            width: 87px;
            background-color: var(--main-color-100);
            cursor: pointer;
        }

        .button_type_box {
            width: 100%;

            .cancel_box {
                display: flex;
                justify-content: center;
                align-items: center;
                color: var(--text-color-100);
                border: 1px solid #f1f1f1;
                font-size: 16px;
                border-radius: 0 0 0px 10px;
                height: 52px;
                width: 100%;
                cursor: pointer;
            }

            .cancel_box + .confirm_box {
                border-radius: 0 0 10px 0px;
            }

            .confirm_box {
                display: flex;
                justify-content: center;
                align-items: center;
                color: #fff;
                font-size: 16px;
                border-radius: 0 0 10px 10px;
                height: 52px;
                width: 100%;
                background-color: var(--main-color-100);
                cursor: pointer;
            }
        }
    }
}
</style>