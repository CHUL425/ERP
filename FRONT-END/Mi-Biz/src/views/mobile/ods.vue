<script setup lang="ts">
import { ref, onBeforeMount, reactive } from 'vue';
import AprvList from '@/components/mobile/view/AprvList.vue';
import RfrncList from '@/components/mobile/view/RfrncList.vue';
import CompleteList from '@/components/mobile/view/CompleteList.vue';
import router from '@/router';
import { useRoute } from 'vue-router';

const route = useRoute();

import api from '@/api';

const searchMode = ref(false);
const keyword: any = ref(null);
const isPreReference: any = ref('1');
const userCd = ref('');
const token: any = ref('');
const userId: any = ref('');

const props = defineProps({
    isPreReference: { type: String }
});

const INIT_SEARCH_PARAM = {
    aprvWrrptOrzCd: '',
    rqsTtlNm: '',
    dcfcPcd: '',
    selTyp: 'rqsr',
    bizTcd: '05',
    pageSize: 99999,
    pageNum: 1
};

const dataParam: any = ref({ ...INIT_SEARCH_PARAM });
const aprvlCnt: any = ref(0);
const preRfrCnt: any = ref(0);

onBeforeMount(() => {
    token.value = '';
    userId.value = '';
    isPreReference.value = props.isPreReference;
    token.value = route.query.CAUTK;
    userId.value = route.query.ID;
    tryLogin();
    setCnt();
});

async function setCnt() {
    const param = {
        ...dataParam.value,
        dcfcPcd: '09'
    };
    const aprvl: any = await api.mobile.selectIng(dataParam.value);
    if (aprvl?.data?.length) {
        aprvlCnt.value = aprvl.data.length;
    } else {
        aprvlCnt.value = 0;
    }
    const preRfr: any = await api.mobile.getSleApvRef(param);
    if (preRfr?.data?.length) {
        preRfrCnt.value = preRfr.data.length;
    } else {
        preRfrCnt.value = 0;
    }
}

async function tryLogin() {
    if (token.value) {
        const param = {
            CAUTK: token.value
        };
        const res: any = await api.mobile.mobileLogin(param);
        if (res?.data?.data?.length) {
            userCd.value = res.data.data[0].epno;
        }
    }

    if (userId.value) {
        const param = {
            userId: userId.value
        };
        const res: any = await api.mobile.pcLogin(param);
        if (res?.data?.data?.length) {
            userCd.value = res.data.data[0].epno;
        }
    }
}

function changeMode(str: any) {
    if (str === '승인') {
        isPreReference.value = '1';
        if (token.value) {
            router.push({ name: 'rot', query: { CAUTK: userCd.value, mnTyp: '' } });
        }
        if (userId.value) {
            router.push({ name: 'rot', query: { ID: userCd.value, mnTyp: '' } });
        }
    } else if (str === '참조') {
        isPreReference.value = '2';
        if (token.value) {
            router.push({ name: 'rot', query: { CAUTK: userCd.value, mnTyp: '09' } });
        }
        if (userId.value) {
            router.push({ name: 'rot', query: { ID: userCd.value, mnTyp: '09' } });
        }
    } else {
        isPreReference.value = '3';
        if (token.value) {
            router.push({ name: 'rot', query: { CAUTK: userCd.value, mnTyp: '00' } });
        }
        if (userId.value) {
            router.push({ name: 'rot', query: { ID: userCd.value, mnTyp: '00' } });
        }
    }
}

function onSearchMode() {
    keyword.value = null;
    searchMode.value = !searchMode.value;
}

function searchKey(e: any) {
    keyword.value?.setKeyword(e.target.value);
    console.log(keyword.value);
}
</script>

<template>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <div class="mb_wrap">
        <div class="mb_header" v-if="searchMode === false">
            <div class="back_btn">
                <a href="javascript:history.go(-1)"><div class="arrow"></div></a>
            </div>
            <div class="btn_set">
                <ul>
                    <li style="width: 35%" :class="{ active: isPreReference === '1' }" @click="changeMode('승인')">
                        승인대기({{ aprvlCnt }})
                    </li>
                    <li style="width: 37%" :class="{ active: isPreReference === '2' }" @click="changeMode('참조')">
                        참조대기({{ preRfrCnt }})
                    </li>
                    <li style="width: 28%" :class="{ active: isPreReference === '3' }" @click="changeMode('완료')">완료</li>
                </ul>
            </div>
            <div class="sch_icon" v-if="isPreReference === '3'">
                <div class="btn_sch">
                    <img src="@/assets/icon/search.png" class="btn_sch_icon" @click="onSearchMode" />
                </div>
            </div>
        </div>
        <div class="mb_header" v-if="searchMode === true">
            <div class="sch_box">
                <img src="@/assets/icon/search.png" class="btn_sch_icon" @click="onSearchMode" />
                <input type="text" @keyup="searchKey" />
            </div>
            <button class="sch_close" @click="onSearchMode"></button>
        </div>
        <div class="guide_wrapper">
            <span class="guide_text">※ 모바일 조회기간은 최대 1년입니다.</span>
        </div>
    </div>
    <template v-if="userCd">
        <AprvList v-if="isPreReference === '1'" @cntUpdate="setCnt()" />
        <RfrncList v-else-if="isPreReference === '2'" @cntUpdate="setCnt()" />
        <CompleteList v-else :searchState="searchMode" ref="keyword" />
    </template>
</template>

<style scoped>
.tac {
    text-align: center;
}

.pl8 {
    padding-left: 8px;
}

.ml4 {
    margin-left: 4px;
}
.ml8 {
    margin-left: 8px;
}

@media screen and (max-width: 1600px) {
    .mb_wrap {
        width: 100%;
        border: 0px solid red;

        .sch_box {
            position: relative;
            width: 100%;
            padding: 0 0 0 16px;
            color: #f58220;
            border: 4px solid #f58220;
            border-radius: 10px;

            img {
                position: relative;
                top: 3px;
            }

            button {
                border: 0;
                background: transparent;
                color: #f58220;
                font-weight: 700;
                font-size: 16px;
                position: relative;
                right: 50px;
                cursor: pointer;
            }

            input {
                width: 90%;
                font-size: 16px;
                border: 0;
                color: #f58220;
            }
        }

        .sch_table {
            padding: 24px;
            background-color: #f8f8f8;
            table {
                width: 100%;
            }
            th {
                text-align: center;
                font-size: 14px;
                padding-bottom: 16px;
                border-bottom: 1px solid #f1f1f1;
            }
            td {
                color: #666666;
                padding-top: 16px;
                padding-bottom: 16px;
                border-bottom: 1px solid #f1f1f1;
                font-size: 12px;
            }
        }
        .mb_header {
            padding: 30px 24px 24px 24px;
            width: 100%;
            display: flex;
            justify-content: flex-start;

            .sch_icon {
                cursor: pointer;
                display: flex;
                align-items: center;

                .btn_sch_icon {
                    width: 22px;
                    height: 22px;
                }
            }

            .sch_close {
                position: absolute;
                right: 42px;
                width: 24px;
                height: 24px;
                top: 44px;
                border: 0px solid red;
                background: #fff;
            }

            .sch_close::before {
                position: absolute;
                top: 10px;
                left: 3px;
                display: inline-block;
                rotate: 45deg;
                width: 24px;
                height: 2px;
                background: #f58220;
                border-radius: 5px;
                content: '';
            }

            .sch_close::after {
                position: absolute;
                top: 10px;
                left: 3px;
                display: inline-block;
                rotate: -45deg;
                width: 24px;
                height: 2px;
                background: #f58220;
                border-radius: 5px;
                content: '';
            }
            .btn_set {
                width: 100%;
                display: block;

                ul {
                    border: 0px solid red;
                    padding: 8px 0;
                    li {
                        font-size: 16px;
                        height: 32px;
                        border-bottom: 2px solid #d4d4d4;
                        padding: 0 70px;
                        color: #999;
                    }
                    .active {
                        font-weight: 700;
                        border: 0;
                        color: #f58220;
                        border-bottom: 2px solid #f58220;
                    }
                }

                .btn_def_left {
                    position: relative;
                    font-size: 12px;
                    text-align: left;
                    width: 90px;
                    height: 40px;
                    border-radius: 8px 0 0 8px;
                    background-color: #f1f1f1;
                    border: 1px solid #d4d4d4;
                    color: #999999;

                    span {
                        position: absolute;
                        text-align: center;
                        line-height: 20px;
                        right: 8px;
                        display: inline-block;
                        content: '';
                        width: 20px;
                        height: 20px;
                        background: #999999;
                        border-radius: 100px;
                        color: #fff;
                    }
                }

                .btn_def_right {
                    position: relative;
                    left: -1px;
                    font-size: 12px;
                    text-align: left;
                    width: 90px;
                    height: 40px;
                    border-radius: 0 8px 8px 0;
                    background-color: #f1f1f1;
                    border: 1px solid #d4d4d4;
                    color: #999999;

                    span {
                        position: absolute;
                        text-align: center;
                        line-height: 20px;
                        right: 8px;
                        display: inline-block;
                        content: '';
                        width: 20px;
                        height: 20px;
                        background: #999999;
                        border-radius: 100px;
                        color: #fff;
                    }
                }

                .active {
                    background-color: #fff;
                    border: 1px solid #d4d4d4;
                    color: #333333;

                    span {
                        position: absolute;
                        text-align: center;
                        line-height: 20px;
                        right: 8px;
                        display: inline-block;
                        content: '';
                        width: 20px;
                        height: 20px;
                        background: #f58220;
                        border-radius: 100px;
                        color: #fff;
                    }
                }
            }
        }
        .guide_wrapper {
            padding-left: 24px;

            .guide_text {
                font-size: 13px;
            }
        }
    }
}

@media screen and (max-width: 430px) {
    .mb_wrap {
        width: 100%;
        border: 0px solid red;

        .sch_box {
            width: 100%;
            height: 48px;
            padding: 0 0 0 16px;
            color: #f58220;
            border: 3px solid #f58220;
            border-radius: 10px;

            img {
                position: relative;
                top: 12px;
            }

            input {
                position: relative;
                top: 8px;
                font-size: 16px;
                height: 24px;
                border: 0;
                color: #f58220;
            }
        }

        .sch_table {
            padding: 24px;
            background-color: #f8f8f8;
            table {
                width: 100%;
            }
            th {
                text-align: center;
                font-size: 14px;
                padding-bottom: 16px;
                border-bottom: 1px solid #f1f1f1;
            }
            td {
                color: #666666;
                padding-top: 16px;
                padding-bottom: 16px;
                border-bottom: 1px solid #f1f1f1;
                font-size: 12px;
            }
        }
        .mb_header {
            padding: 24px;
            width: 100%;
            position: relative;
            display: flex;
            justify-content: space-between;

            .sch_icon {
                cursor: pointer;
                display: flex;
                align-items: center;
            }

            .sch_close {
                position: absolute;
                /*left: 324px;*/
                width: 24px;
                height: 24px;
                top: 38px;
                border: 0px solid red;
                background: #fff;
            }

            .sch_close::before {
                position: absolute;
                top: 10px;
                left: 3px;
                display: inline-block;
                rotate: 45deg;
                width: 24px;
                height: 2px;
                background: #f58220;
                border-radius: 5px;
                content: '';
            }

            .sch_close::after {
                position: absolute;
                top: 10px;
                left: 3px;
                display: inline-block;
                rotate: -45deg;
                width: 24px;
                height: 2px;
                background: #f58220;
                border-radius: 5px;
                content: '';
            }
            .btn_set {
                display: block;
                width: 94%;

                ul {
                    width: 100%;
                    border: 0px solid red;
                    padding: 8px 0;
                    li {
                        text-align: center;
                        font-size: 14px;
                        height: 32px;
                        border-bottom: 2px solid #d4d4d4;
                        padding: 0 10px;
                        color: #999;
                    }
                    .active {
                        font-weight: 700;
                        border: 0;
                        color: #f58220;
                        border-bottom: 2px solid #f58220;
                    }
                }

                .btn_def_left {
                    position: relative;
                    font-size: 12px;
                    text-align: left;
                    width: 90px;
                    height: 40px;
                    border-radius: 8px 0 0 8px;
                    background-color: #f1f1f1;
                    border: 1px solid #d4d4d4;
                    color: #999999;

                    span {
                        position: absolute;
                        text-align: center;
                        line-height: 20px;
                        right: 8px;
                        display: inline-block;
                        content: '';
                        width: 20px;
                        height: 20px;
                        background: #999999;
                        border-radius: 100px;
                        color: #fff;
                    }
                }

                .btn_def_right {
                    position: relative;
                    left: -1px;
                    font-size: 12px;
                    text-align: left;
                    width: 90px;
                    height: 40px;
                    border-radius: 0 8px 8px 0;
                    background-color: #f1f1f1;
                    border: 1px solid #d4d4d4;
                    color: #999999;

                    span {
                        position: absolute;
                        text-align: center;
                        line-height: 20px;
                        right: 8px;
                        display: inline-block;
                        content: '';
                        width: 20px;
                        height: 20px;
                        background: #999999;
                        border-radius: 100px;
                        color: #fff;
                    }
                }

                .active {
                    background-color: #fff;
                    border: 1px solid #d4d4d4;
                    color: #333333;

                    span {
                        position: absolute;
                        text-align: center;
                        line-height: 20px;
                        right: 8px;
                        display: inline-block;
                        content: '';
                        width: 20px;
                        height: 20px;
                        background: #f58220;
                        border-radius: 100px;
                        color: #fff;
                    }
                }
            }
        }
    }
}

.back_btn {
    position: absolute;
    top: 23px;
    .arrow {
        width: 13px;
        height: 13px;
        position: relative;
        margin-bottom: 23px;
        transform: rotate(-45deg);
    }
    .arrow::before,
    .arrow::after {
        content: '';
        position: absolute;
    }

    .arrow::before {
        width: 100%;
        height: 100%;
        border: 1px solid #999;
        border-right: 0;
        border-bottom: 0;
    }

    .arrow::after {
        width: 25px;
        height: 1px;
        background: #999;
        transform-origin: 0 100%;
        transform: rotate(45deg);
    }
}
</style>
