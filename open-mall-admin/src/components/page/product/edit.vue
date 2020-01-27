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
                        <el-select v-model="formData.categroyId" placeholder="请选择" @change="selectItem">
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

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品品牌名称：" prop="商品品牌名称：">
                        <el-select v-model="formData.brandId" placeholder="请选择" @change="selectBrandItem">
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
                loginUserType:localStorage.getItem('userType'),
                loginCompanyNo:localStorage.getItem('companyNo'),
                enable :false,
                oldData: null,
                isInactive: false,
                formData: {},
                rules: {},
                categoryList: [],
                selectCateName : "",
                selectBrandName : "",
                brandList: []
            }
        },
        created() {
            let self = this;
            requestData({
                "url": "/api/open-mall-product/productCategory/list",
                "data": {},
                "callback": function (redata) {
                    for (let i = 0; i < redata.values.length;i ++) {
                        let category = {};
                        category.value = redata.values[i].id;
                        category.label = redata.values[i].categroyName;
                        self.categoryList.push(category);
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
                    }
                }
            });
            this.getData();
        },
        methods: {
            getData() {
                let self = this;
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
                let self = this;
                self.formData.categroyName = this.selectCateName;
                self.formData.brandName = this.selectBrandName;
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
                let isValid = false;
                this.$refs["formData"].validate((valid) => {
                    if (valid) {
                        isValid = true;
                    } else {
                        isValid = false;
                    }
            });
                return isValid;
            },
            selectItem(value){
                let obj = {};
                // this.categoryList.forEach(i => console.log(i));
                obj = this.categoryList.find((item)=>{
                    return item.value === value;//筛选出匹配数据
                });
                this.selectCateName = obj.label;
                console.log(this.selectCateName);//我这边的name就是对应label的
            },
            selectBrandItem(value){
                let obj = {};
                obj = this.brandList.find((item)=>{
                    return item.value === value;//筛选出匹配数据
                });
                this.selectBrandName = obj.label;
                console.log(this.selectBrandName);//我这边的name就是对应label的
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
