<script setup lang="ts">
import { ref, onMounted, watch } from 'vue';
import api from '@/api';
import moment from 'moment';
import AprvDetail from '@/components/mobile/AprvDetail.vue';
import { formatDate } from '@/composables/useGlobal';

const props = defineProps({
    searchState: {
        type: Boolean,
        default: false
    }
});

watch(
    () => props.searchState,
    (newVal) => {
        if (newVal === false) {
            searchData();
        }
    }
);

const INIT_SEARCH_PARAM = {
    qryEndDt: moment().format('YYYYMMDD'),
    qryStrtDt: moment().subtract(1, 'year').format('YYYYMMDD'),
    mobSelTxt: '인감',
    pageNum: 1,
    pageSize: 9999
};

const INIT_UI_DATA = {
    listData: [],
    selectItem: {},
    userInfo: {}
};

const dataParam: any = ref({ ...INIT_SEARCH_PARAM });
const dataUI: any = ref({ ...INIT_UI_DATA });
const isOpen = ref(false);

defineExpose({
    setKeyword
});

async function setKeyword(newkey: any) {
    console.log(newkey);

    const param: any = {
        qryEndDt: moment().format('YYYYMMDD'),
        qryStrtDt: moment().subtract(1, 'year').format('YYYYMMDD'),
        pageNum: 1,
        pageSize: 10,
        mobSelTxt: newkey,
        mobSelTyp: 'txt'
    };
    if (newkey) {
        const res: any = await api.mobile.selectCmpn(param);

        if (res?.data?.length) {
            dataUI.value.listData = res.data;
        } else {
            dataUI.value.listData = [];
        }
    }
}

onMounted(() => {
    searchData();
});

async function searchData() {
    const res: any = await api.mobile.selectCmpn(dataParam.value);
    if (res?.data?.length) {
        dataUI.value.listData = res.data;
        dataUI.value.listData.forEach((item: any) => {
            item.isActive = false;
            item.state = 'complete';
        });
    }
}

function toggleAccordion(item: any) {
    dataUI.value.listData.some((element: any) => {
        if (element.isActive === true) {
            element.isActive = false;
            dataUI.value.listData.some((element: any) => {
                if (element.rctNo === item.rctNo) {
                    item.isActive = !item.isActive;
                    element.isActive = !element.isActive;
                    isOpen.value = !isOpen.value;
                    dataUI.value.selectItem = item;
                    return element.rctNo === item.rctNo;
                }
            });
        } else {
            if (element.rctNo === item.rctNo) {
                element.isActive = !element.isActive;
                isOpen.value = !isOpen.value;
                dataUI.value.selectItem = item;
            }
        }
    });
}

function closeData(e: any) {
    dataUI.value.listData.some((element: any) => {
        if (element.rctNo === e) {
            element.isActive = !element.isActive;
            isOpen.value = !isOpen.value;
            return element.rctNo === e;
        }
    });
}
</script>

<template>
    <div class="mb_table">
        <table>
            <thead>
                <tr>
                    <th>신청일</th>
                    <th>신청명</th>
                    <th>진행상태</th>
                </tr>
            </thead>
            <template v-if="dataUI.listData.length > 0">
                <tbody v-for="(item, idx) in dataUI.listData" :key="idx">
                    <tr @click="toggleAccordion(item)">
                        <td class="tac">{{ formatDate(item.rqsDt) }}</td>
                        <td class="pl8" style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap">{{ item.rqsTtlNm }}</td>
                        <td class="tac">
                            <span
                                class="status_caption"
                                :class="{
                                    ing: item.rqsScdNm === '승인중',
                                    succ: item.rqsScdNm === '승인완료',
                                    return: item.rqsScdNm === '반려',
                                    retract: item.rqsScdNm === '철회',
                                    temporary: item.rqsScdNm === '임시저장',
                                    finish: item.rqsScdNm === '처리완료',
                                    submit: item.rqsScdNm === '사용처제출',
                                    disposal: item.rqsScdNm === '원본폐기'
                                }"
                                >{{ item.rqsScdNm }}</span
                            >
                        </td>
                    </tr>

                    <AprvDetail
                        v-if="isOpen && dataUI.listData[idx].isActive"
                        :data="dataUI.selectItem"
                        @onClose="(e:any) => closeData(e)"
                    />
                </tbody>
            </template>
            <template v-else>
                <tbody>
                    <tr class="emptyTb">
                        <td colspan="3"><strong class="emptyMsg">표기할 데이터가 없어요.</strong></td>
                    </tr>
                </tbody>
            </template>
        </table>
    </div>
</template>

<style scoped>
.mb_table {
    display: flex;
    width: 100%;
    padding: 24px;

    .status_caption {
        display: inline-block;
        line-height: 25px;
        width: 65px;
        height: 25px;
        border-radius: 100px;
        text-align: center;
    }
    .succ {
        background: #f58228;
        border: 1px solid #d4d4d4;
        color: #fff;
    }
    .return {
        background: rgba(233, 32, 32, 0.1);
        border: 1px solid #e92090;
        color: #e92090;
    }

    .ing {
        background: rgba(255, 158, 30, 0.1);
        border: 1px solid #ff9e1e;
        color: #ff9e1e;
    }

    .retract {
        background: rgba(194, 172, 151, 0.1);
        border: 1px solid #c2ac97;
        color: #c2ac97;
    }

    .temporary {
        background: #f1f1f1;
        border: 1px solid #d4d4d4;
        color: #999999;
    }

    .finish {
        background: #999;
        color: #fff;
        border: 1px solid #868686;
    }

    .submit {
        background: #efefef;
        color: #716f81;
        border: 1px solid #c4c4c4;
    }

    .disposal {
        background: #e8eae6;
        color: #758b6d;
        border: 1px solid #cdd0cb;
    }

    table {
        width: 100%;
        table-layout: fixed;
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
        white-space: nowrap;
    }

    .tac {
        text-align: center;
    }
}

.emptyTb {
    height: 200px;
    width: 100%;
    text-align: center;

    .emptyMsg {
        line-height: 180px;
    }
}
</style>
