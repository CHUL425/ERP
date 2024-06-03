<script setup lang="ts">
import { watch, ref, computed, onMounted } from 'vue';

const emit = defineEmits(['close']);

const props = defineProps({
    data: {
        type: String,
        default: '',
        required: true
    }
});

const link: any = ref('');
watch(
    () => props.data,
    (newVal) => {
        if (newVal) {
            console.log(props.data);
            link.value = newVal;
        }
    }
);

onMounted(() => {
    console.log(props.data);
    setUrl();
    setIframeUrl();
});

const url: any = computed(() => {
    return props.data;
});

const docUrl: any = ref('');
function setUrl() {
    console.log(url.value);
    docUrl.value = url.value;
}

function setIframeUrl() {
    const frame: any = document.getElementById('main_iframe');

    if (frame) {
        frame.src = docUrl.value;
    }
}

function popClose() {
    emit('close');
}
</script>

 
<template>
    <div class="popWrapper">
        <div class="popHeader">
            <button class="common_detail_wrap_btn_close" @click="popClose"></button>
            <span class="header_title">첨부파일 보기</span>
        </div>
        <div class="popContainer">
            <iframe id="main_iframe" name="main_iframe" :src="docUrl" frameborder="0"></iframe>
        </div>
    </div>
</template>

<style scoped>
.popWrapper {
    position: fixed;
    top: 0px;
    right: 0px;
    width: 100%;
    height: 100%;
    transition: all 0.5s ease-in-out;
    z-index: 991;
    border-radius: 5px;
    background-color: #333;
    box-shadow: -2px 5px 33px 6px rgba(0, 0, 0, 0.15);
    display: flex;
    flex-direction: column;

    .popHeader {
        height: 60px;
        background-color: #f58220;
        display: flex;

        .common_detail_wrap_btn_close {
            position: absolute;
            left: 10px;
            top: 8px;
            background: transparent;
            border: 0px solid red;
            width: 35px;
            height: 40px;
            cursor: pointer;
        }

        .common_detail_wrap_btn_close button {
            display: block;
        }

        .common_detail_wrap_btn_close:before,
        .common_detail_wrap_btn_close:after {
            position: absolute;
            right: 16px;
            top: 0;
            content: '';
            height: 25px;
            width: 1px;
            background-color: #fff;
        }

        .common_detail_wrap_btn_close:before {
            transform: rotate(45deg);
        }

        .common_detail_wrap_btn_close:after {
            transform: rotate(-45deg);
        }

        .header_title {
            position: absolute;
            left: 49px;
            top: 11px;
            color: #fff;
            font-size: 15px;
        }
    }

    .popContainer {
        height: 100%;
        padding: 20px 20px 70px 20px;
        position: relative;
        width: 100%;
        padding-bottom: 52.25%;
    }

    .popContainer iframe {
        position: absolute;
        width: 100%;
        height: 100%;
        border: none;
    }
}
</style>