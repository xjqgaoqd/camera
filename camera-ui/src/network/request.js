import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8088', // 根据实际情况设置后端API的基础URL
  timeout: 10000, // 设置请求超时时间
});

export const fetchProducts = async (pageIndex, pageSize, filter) => {
  try {
        const response = await instance.post('/camera-start/cameraInfo/queryCameraInfoByCondition', {
        pageIndex,
        pageSize,
        filter
    });

    return response.data; // 返回获取的数据
  } catch (error) {
    console.error('Error fetching products:', error);
    throw error;
  }
};
