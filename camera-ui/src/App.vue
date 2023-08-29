<script setup>
// import HelloWorld from './components/HelloWorld.vue';
import CameraInfo from './components/info/CameraInfo.vue';
</script>

<template>
  <!-- <div>
    <a href="https://vitejs.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div> -->
  <!-- <HelloWorld msg="fff" /> -->
  <CameraInfo />
</template>

<style scoped>

/* 全局样式 */

/* 重置默认的 margin 和 padding */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* 页面背景色 */
body {
  background-color: #f5f5f5;
}

/* 公共文本样式 */
body, p, h1, h2, h3, h4, h5, h6 {
  font-family: Arial, sans-serif;
  color: #333;
}

/* 按钮样式 */
button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
