<script setup lang="ts">
import { ref } from 'vue';
import api from '@/api';

const response = ref('');

async function test(param: string) {
    if (param === 'TEST_LOGIN') {
        response.value = await api.user.loginUserByOtp(3329432, 123);
    } else if (param === 'TEST_GET_LIST') {
        response.value = await api.mobile.selectList({
            rqsOrzCd: '',
            rqsTtlNm: '',
            rqsEpno: '',
            qryStrtDt: '19000101',
            qryEndDt: '99991231',
            pageSize: 50,
            pageIndex: 0
        });
    } else if (param === '3') {
    }
}
</script>

<template>
    <div style="display: flex; padding: 10px 10px 0 10px">
        <button @click="test('TEST_LOGIN')">로그인 시도</button>
        <button @click="test('TEST_GET_LIST')">승인정보 요청</button>
    </div>
    <div style="border: 1px black solid; padding: 12px; margin: 12px; min-height: 80vh">
        {{ response }}
    </div>
</template>
