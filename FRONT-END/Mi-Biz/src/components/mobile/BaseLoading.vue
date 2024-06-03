<script lang="ts" setup>
import { ref, computed, watch } from 'vue';
import { useGlobalUiStore } from '@/store/global-ui';
import router from '@/router';

const globalStore = useGlobalUiStore();

const isLoading = defineProps({
    modelValue: {
        type: Boolean,
        default: false
    },
    state: {
        type: String,
        default: ''
    }
});

const TIMEOUT = 60000;
const timeoutId: any = ref();

watch(isLoading, (start) => {
    console.log(isLoading);
    if (start) {
        timeoutId.value = setTimeout(timeoutLogic, TIMEOUT);
    } else {
        globalStore.stopLoading();
        clearTimeout(timeoutId.value);
    }
});

function timeoutLogic() {
    // TODO TIMEOUT 타임아웃
    // router.replace('/login');
    globalStore.stopLoading();
}
</script>

<template>
    <div v-if="isLoading" class="spinner_loading_wrap">
        <div class="spinner">
            <span class="spinner-inner-1"></span>
            <span class="spinner-inner-2"></span>
            <span class="spinner-inner-3"></span>
        </div>
    </div>
</template>

<style scoped lang="scss">
.spinner_loading_wrap {
    background: rgba(255, 255, 255, 0.5);
    position: fixed;
    top: 0;
    right: 0;
    left: 0;
    bottom: 0;
    z-index: 9999999999;
    transition: 0.1s;
}

$spinner: salmon;
$background: white;
$size: 30px;

html {
    background-color: $background;
}

.spinner {
    position: absolute;
    top: calc(50% - calc($size / 2));
    left: calc(50% - calc($size / 2));
    width: $size;
    height: $size;
    animation: spinner 0.75s linear infinite;

    span {
        position: absolute;
        width: 100%;
        height: 100%;
        border-radius: 50%;
    }

    .spinner-inner-1 {
        background: linear-gradient(to right, rgba($spinner, 0) 0%, rgba($spinner, 0) 50%, $spinner 51%);
    }

    .spinner-inner-2 {
        background: linear-gradient(to top, rgba($background, 0) 0%, $background 100%);
    }

    .spinner-inner-3 {
        $offset: $size * 0.1;
        top: $offset;
        left: $offset;
        width: $size - ($offset * 2);
        height: $size - ($offset * 2);
        background: $background;
    }
}

@keyframes spinner {
    0% {
        transform: rotate(0deg);
    }
    100% {
        transform: rotate(360deg);
    }
}
</style>
