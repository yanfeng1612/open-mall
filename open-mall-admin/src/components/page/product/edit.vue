<template>
    <el-form :rules="rules" :model="formData" ref="formData" label-width="160px" class="demo-ruleForm">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i> 商品基本属性表</el-breadcrumb-item>
                <el-breadcrumb-item>编辑商品基本属性表</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container container-margin">
            <el-input v-model="formData.id" type="hidden" />

<!--            <el-row>-->
<!--                <el-col :span="8">-->
<!--                    <el-form-item label="自动编号：" prop="自动编号">-->
<!--                        <el-input v-model="formData.id" placeholder="id"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品名称：" prop="商品名称">
                        <el-input v-model="formData.productName" placeholder="productName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品单位：" prop="商品单位">
                        <el-input v-model="formData.unit" placeholder="unit"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品分类名称：" prop="商品分类名称">
                        <el-select v-model="formData.produtCategoryId" placeholder="请选择">
                            <el-option
                                v-for="item in categoryList"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>

<!--            <el-row>-->
<!--                <el-col :span="8">-->
<!--                    <el-form-item label="商品品牌名称：" prop="商品品牌名称">-->
<!--                        <el-input v-model="formData.brandName" placeholder="brandName"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品品牌名称：" prop="商品品牌名称：">
                        <el-select v-model="formData.produtBrandId" placeholder="请选择">
                            <el-option
                                    v-for="item in brandList"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="描述：" prop="描述">
                        <el-input v-model="formData.description" placeholder="description"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="图片路径：" prop="图片路径">
                        <el-input v-model="formData.imgePath" placeholder="imgePath"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="货号：" prop="货号">
                        <el-input v-model="formData.serialNumber" placeholder="serialNumber"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="售价：" prop="售价">
                        <el-input v-model="formData.price" placeholder="price"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="市场价：" prop="市场价">
                        <el-input v-model="formData.marketPrice" placeholder="marketPrice"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="库存：" prop="库存">
                        <el-input v-model="formData.stock" placeholder="stock"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="重量（单位克）：" prop="重量（单位克）">
                        <el-input v-model="formData.weight" placeholder="weight"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="排序：" prop="排序">
                        <el-input v-model="formData.rank" placeholder="rank"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="数据状态 0-无效 1-有效：" prop="数据状态 0-无效 1-有效">
                        <el-input v-model="formData.yn" placeholder="yn"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

<!--            <el-row>-->
<!--                <el-col :span="8">-->
<!--                    <el-form-item label="创建时间：" prop="创建时间">-->
<!--                        <el-input v-model="formData.createdTime" placeholder="createdTime"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->

<!--            <el-row>-->
<!--                <el-col :span="8">-->
<!--                    <el-form-item label="修改时间：" prop="修改时间">-->
<!--                        <el-input v-model="formData.modifiedTime" placeholder="modifiedTime"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->

        </div>
        <div class="container-margin to-center ">
            <el-button type="primary" @click="toSave">保 存</el-button>
            <el-button type="primary" @click="toCancel">取 消</el-button>
        </div>
    </el-form>
</template>

<script>
    import {requestData} from "../../../utils/request";

    export default {
        name: 'baseform',
        data: function () {
            return {
                selectItem: null,
                loginUserType:localStorage.getItem('userType'),
                loginCompanyNo:localStorage.getItem('companyNo'),
                enable :false,
                oldData: null,
                isInactive: false,
                formData: {},
                rules: {},
                categoryList: [],
                brandList: []
            }
        },
        created() {
            let self = this;
            requestData({
                "url": "/api/open-mall-product/productCategory/list",
                "data": {},
                "callback": function (redata) {
                    // self.formData = redata;
                    console.log(redata);
                    for (let i = 0; i < redata.values.length;i ++) {
                        let category = {};
                        category.value = redata.values[i].id;
                        category.label = redata.values[i].categroyName;
                        self.categoryList.push(category);
                        self.formData = redata;
                    }
                }
            });
            requestData({
                "url": "/api/open-mall-product/productBrand/list",
                "data": {},
                "callback": function (redata) {
                    for (let i = 0; i < redata.values.length;i ++) {
                        let brand = {};
                        brand.value = redata.values[i].id;
                        brand.label = redata.values[i].brandName;
                        self.brandList.push(brand);
                        self.formData = redata;
                    }
                }
            });
            this.getData();
        },
        methods: {
            getData() {
                var self = this;
                if (this.$route.query.id != null) {
                    requestData({
                        "url": "/api/open-mall-product/product/detail",
                        "data": {id: this.$route.query.id},
                        "callback": function (redata) {
                            self.formData = redata;
                        }
                    });
                }
            },
            toSave() {
                var self = this;

                this.$refs["formData"].validate((valid) => {
                    if (valid) {
                        requestData({
                            "url": "/api/open-mall-product/product/custom/insert",
                            "data": this.formData,
                            "callback": function (redata) {
                                self.$message({
                                    type: 'success',
                                    message: '保存成功!'
                                });
                                self.$router.push({path: '/productList'});
                            }
                        });

                    }
                });
            },
            toCancel() {
                this.$router.push({path: '/productList'});
            },
            onSubmit: function () {
                var isValid = false;
                this.$refs["formData"].validate((valid) => {
                    if (valid) {
                        isValid = true;
                    } else {
                        isValid = false;
                    }
            });
                return isValid;
            }
        }
    }
</script>
<style>
    .container-margin {
        margin-top: 10px;
    }

    .bold {
        font-weight: bold;
        color: #606266;
    }

    .to-right {
        text-align: right;
    }

    .to-center {
        text-align: center;
    }

    .el-row {

        margin-top: 10px;

    }
    :last-child {
        margin-bottom: 0;
    }

    .el-col {
        border-radius: 4px;
    }

    .bg-purple-dark {
        background: #99a9bf;
    }

    .bg-purple {
        background: #d3dce6;
    }

    .bg-purple-light {
        background: #e5e9f2;
    }

    .grid-content {
        border-radius: 4px;
        min-height: 36px;
        color: #606266;
    }

    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
</style>
