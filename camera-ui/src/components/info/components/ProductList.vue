<template>
    <div class="product-list">
      <!-- <div :key="product.id" > -->
        <ProductDisplay
        class="product-item"
        v-for="product in products" 
        :key="product.id"
        :imageUrl="product.mainImg.filePath"
        :brand="product.brand"
        :model="product.model"
        :issueTime="product.issueTime"
        :content="product.content"
        :nowPrice="product.nowPrice"
        :issuePrice="product.issuePrice"
        />
        <!-- <div class="product-image">
          <img :src="'/pic/'+product.image" alt="Product Image" />
        </div>
        <div class="product-info">
          <div class="product-brand">{{ product.brand }}</div>
          <div class="product-model">{{ product.model }}</div>
          <div class="product-issue-time">{{ product.issueTime }}</div>
          <div class="product-content">{{ product.content }}</div>
        </div> -->
      </div>
    <!-- </div> -->
  </template>
  
  <script>
  import ProductDisplay from './items/ProductDisplay.vue'

  export default {
    props: {
      products: Array, // 商品数据，包含 brand、model、issueTime、content、image 等字段
    },
    components:{
      ProductDisplay:ProductDisplay
    }
  };
  </script>
  
  <style scoped>
  .product-list {
    display: flex;
    flex-wrap: wrap;
  }
  
  .product-item {
    border: 1px solid #ccc;
    margin: 10px;
    padding: 10px;
    display: flex;
  }
  
  .product-image {
    flex: 1;
    max-width: 150px;
  }
  
  .product-info {
    flex: 2;
    padding-left: 10px;
  }
  
  .product-brand {
    font-weight: bold;
  }
  
  /* 其他样式 */
  </style>
  