<template>
    <div class="notFound_container">
        <img src="@/assets/logo.png" class="img_card" />
        <div class="form_box">
            <div class="title">Mi-Square 앱에서 접속해주세요.</div>
        </div>
    </div>
</template>

<script lang="ts" setup>
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
    }
}
</style>
