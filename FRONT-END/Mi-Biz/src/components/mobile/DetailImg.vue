<script setup lang="ts">
import { watch, ref, onMounted } from 'vue';
import api from '@/api';
import { getDomain } from '@/composables/useGlobal.ts';
import { fileController } from '@/composables/useGlobal';
const apiUrl = getDomain();
const fileNo: any = ref('');
const fileDlNo: any = ref('');

import { useRoute } from 'vue-router';

const route = useRoute();
const link = ref('');
onMounted(() => {
    // fileController.download(fileInfo.fileNo, fileInfo.fileDlNo);
    console.log(window.location.href);
    link.value = window.location.href;
    fileNo.value = route.query.fileNo;
    fileDlNo.value = route.query.fileDlNo;

    fileDown();
});

async function fileDown() {
    const fileState: any = fileController.download(fileNo.value, fileDlNo.value);

    console.log(fileState);
    callSynapDocumentViewer();
}

import moment from 'moment';
import axios from 'axios';
import $ from 'jquery';
const data: any = ref({});
import router from '@/router';

async function callSynapDocumentViewer() {
    let d = new Date();
    let second = 1000 * 60;
    const sConnectUrl: any = getDomain();
    const url: any = ref('');
    if (sConnectUrl === 'http://bizdev.miraeassetsecurities.com/') {
        url.value = 'https://docvwdev.miraeassetsecurities.com:8443/SynapDocViewServer/';
    } else if (sConnectUrl === 'http://biztest.miraeassetsecurities.com/') {
        url.value = 'https://docvw.miraeassetsecurities.com:8443/SynapDocViewServer/';
    } else if (sConnectUrl === 'http://biz.miraeassetsecurities.com/') {
        url.value = 'https://docvwdp.miraeassetsecurities.com:443/SynapDocViewServer/';
    } else {
        url.value = 'https://docvwdev.miraeassetsecurities.com:8443/SynapDocViewServer/';
    }

    // var thisObj = file;
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
    var vurl = url.value;

    var params = {
        filePath: link.value, // 파일 주소
        fileType: fileType,
        fid: fid, // 파일 고유번호
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
            data.value = error;
            console.log(error.status + ' : ' + error.statusText);
            console.log('error' + request.responseJSON);
        },
        success: function (data: any) {
            data.value = data;
            if (data != null) {
                console.log(data);
                var viewUrl = vurl + data.viewUrlPath;
                console.log('received view url : ' + data.viewUrlPath);
                console.log('this is view url : ' + viewUrl);

                // if (qry_type == 'webView') {
                //     thisObj.webView.setUrl(viewUrl);
                // }
            }
        }
    });
}
</script>
 
<template>
    <div class="common_detail">
        {{ data }}
    </div>
</template>

<style scoped>
@media screen and (max-width: 1600px) {
    .mb_wrap {
        width: 100%;
        border: 0px solid red;
        z-index: 999;
    }

    .common_detail {
        .common_detail_img {
            width: auto;
            overflow-x: hidden;

            .detail_img {
                display: block;
                width: 100%;
                height: auto;
            }
        }
    }
}

@media screen and (max-width: 430px) {
    .mb_wrap {
        width: 100%;
        border: 0px solid red;
        z-index: 999;
    }

    .common_detail {
        .common_detail_img {
            width: auto;
            overflow-x: hidden;

            .detail_img {
                display: block;
                width: 100%;
                height: auto;
            }
        }
    }
}
</style>