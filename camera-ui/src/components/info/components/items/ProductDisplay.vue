<template>
  <div class="product">
    <el-tooltip placement="bottom" effect="light" :content=content>
    <div class="product-image">
        <img :src="'/pic/' + imageUrl" alt="Product Image" />
    </div>
  </el-tooltip>
    <div class="product-details">
      <h3>{{ brand }} {{ model }}</h3>
      <p>发布时间: {{ issueTime }}</p>
      <p>现价: {{ nowPrice }}</p>
      <p>发布价: {{ issuePrice }}</p>
    </div>
    <!-- <div class="description-content">
      <p>{{ content }}</p>
    </div> -->
  </div>
</template>

<script>
export default {
  props: {
    imageUrl: String,
    brand: String,
    model: String,
    issueTime: String,
    content: String,
    nowPrice: String,
    issuePrice: String,
  },
};
</script>

<style scoped>
.product {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px;
  display: flex;
  flex-direction: column;
}

.product-image {
  text-align: center;
}

.product img {
  width: 150px; /* 固定宽度 */
  height: 150px; /* 固定高度 */
  object-fit: cover; /* 保持纵横比，截取多余部分 */
}

.product-details {
  text-align: center;
  margin-top: 10px;
}

</style>
