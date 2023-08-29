import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(),
    {
      name: 'vite:import-analysis',
      // 设置为 false 来禁用 import-analysis 插件
      enforce: false
    }],
    resolve: {
      alias: {
        'element-plus/lib/theme-chalk/index.css': 'element-plus/theme-chalk/index.css'
      }
    }
})
