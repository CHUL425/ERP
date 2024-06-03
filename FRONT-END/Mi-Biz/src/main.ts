import { createApp } from 'vue';
import { createPinia } from 'pinia';
import './global/index';

import App from './App.vue';
import router from './router';

const app = createApp(App);
const pinia = createPinia();

app.use(router).use(pinia).mount('#app');

// global Components
