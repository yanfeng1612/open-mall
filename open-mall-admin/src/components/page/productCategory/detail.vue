<template>
    <el-form :model="ajaxData" ref="ajaxData" label-width="200px" class="demo-ruleForm">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i> 商品分类表</el-breadcrumb-item>
                <el-breadcrumb-item>商品分类表-详情信息</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container container-margin">

            <el-row>
                <el-col :span="8">
                    <el-form-item label="自动编号：" prop="id">
                            {{ajaxData.id}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="商品分类名称：" prop="categroyName">
                            {{ajaxData.categroyName}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="分类描述：" prop="description">
                            {{ajaxData.description}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="排序：" prop="rank">
                            {{ajaxData.rank}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="数据状态 0-无效 1-有效：" prop="yn">
                            {{ajaxData.yn}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="创建时间：" prop="createdTime">
                            {{ajaxData.createdTime}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="修改时间：" prop="modifiedTime">
                            {{ajaxData.modifiedTime}}
                    </el-form-item>
                </el-col>
            </el-row>

        </div>
        <div class="container-margin to-center ">
            <el-button type="primary" @click="cancelDetail()">返回</el-button>
        </div>
    </el-form>

</template>

<script>
   import {requestData} from "../../../utils/request";

    export default {
        name: 'baseform',
        data: function () {
            return {
                ajaxData: {

                },
                item :{id:this.$route.query.id},
            }
        },
        created() {
            this.getData();
        },
        methods: {
            getData() {
                let self = this;
                if (this.item.id == null || this.item.id == undefined) {
                    return;
                }
                var reqData = {"id":this.item.id};
                requestData({
                    "url": "/api/productCategory/detail",
                    "data":reqData,
                    "callback": function (redata) {
                        if(redata == null || redata == undefined) {
                            return;
                        }
                        self.ajaxData = redata;
                    }
                });
            },
            handlePreview(file) {
                console.log(file);
            },
            cancelDetail: function () {
                this.$router.push({path: '/productCategoryList'});
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
