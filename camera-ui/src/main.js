import { createApp } from 'vue';
import App from './App.vue';
import ElementPlus from 'element-plus'; // 引入 Element Plus
import 'element-plus/lib/theme-chalk/index.css'; // 引入 Element Plus 样式

createApp(App)
  .use(ElementPlus) // 使用 Element Plus
  .mount('#app');

