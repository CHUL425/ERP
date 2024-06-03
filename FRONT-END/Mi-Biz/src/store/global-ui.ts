import { defineStore } from 'pinia';
import { computed, ref } from 'vue';

export const useGlobalUiStore = defineStore('global-ui', () => {
    const TIME_TOAST_AUTO_CLOSE = 3000;

    interface Toast {
        id: Symbol;
        message: string;
        type: string;
    }

    const originalListToast = ref(<Array<Toast>>[]);
    const listToast = computed(() => originalListToast.value.reverse());

    function showToast(message: string, type: string = 'main') {
        const id = Symbol();
        originalListToast.value.push({
            message,
            type,
            id
        });

        setTimeout(() => {
            const index = originalListToast.value.findIndex((toast) => toast.id === id);
            if (index > -1) {
                popToast(index);
            }
        }, TIME_TOAST_AUTO_CLOSE);
    }

    function popToast(index: number) {
        originalListToast.value.splice(index, 1);
    }

    interface Popup {
        title?: string;
        description?: string;
        positiveLabel?: string;
        positiveCallback?: Function;
        negativeLabel?: string;
        negativeCallback?: Function;
    }

    const popupInfo = ref(<Popup>{});
    const isPopupOpen = ref(false);

    function showAlert(newInfo: Popup) {
        popupInfo.value = newInfo;
        isPopupOpen.value = true;
    }

    function closeAlert() {
        isPopupOpen.value = false;
    }

    const isLoadingOpen = ref(false);

    function startLoading() {
        isLoadingOpen.value = true;
    }

    function stopLoading() {
        isLoadingOpen.value = false;
    }

    return {
        listToast,
        showToast,
        popToast,
        popupInfo,
        isPopupOpen,
        showAlert,
        closeAlert,
        isLoadingOpen,
        startLoading,
        stopLoading
    };
});
