<template>
    <div class="back_btn">
        <a href="javascript:history.go(-1)"><div class="arrow"></div></a>
    </div>
    <div class="notFound_container">
        <img src="@/assets/logo.png" class="img_card" />
        <div class="form_box">
            <div class="title">404 - 페이지를 찾을 수 없습니다</div>
            <div class="button_box" @click="() => router.push('/rot')">승인관리로 이동</div>
        </div>
    </div>
</template>

<script lang="ts" setup>
import { useRouter } from 'vue-router';
const router = useRouter();
</script>

<style scoped>
.notFound_container {
    max-width: 600px !important;
    background-color: #fff;
    border-radius: 5px;
    padding: 20px 25px 30px;
    margin: 10% auto 0 auto;

    .img_card {
        width: 180px;
        height: 50px;
        margin: 0 auto 20px;
        display: block;
        background-image: none;
        background-color: #fff;
    }

    .form_box {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        .title {
            padding: 30px 0;
            font-size: 1.8rem;
            text-align: center;
            color: var(--text-color-100);
            font-weight: bold;
        }

        .button_box {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 130px;
            height: 40px;
            font-size: 0.9rem;
            border: 1px solid var(--border-color-100);
            border-radius: 5px;
            color: var(--text-color-100);
            cursor: pointer;
            transition: 0.1s ease-out;
        }
    }
}

.back_btn {
    position: absolute;
    top: 23px;
    left: 24px;
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
