<template>
    <el-form :model="ajaxData" ref="ajaxData" label-width="200px" class="demo-ruleForm">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i> 订单master表</el-breadcrumb-item>
                <el-breadcrumb-item>订单master表-详情信息</el-breadcrumb-item>
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
                    <el-form-item label="全局唯一order_key：" prop="orderKey">
                            {{ajaxData.orderKey}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="用户id：" prop="userId">
                            {{ajaxData.userId}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="用户名称：" prop="userName">
                            {{ajaxData.userName}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="用户性别  0-未知   1-男  2-女：" prop="sex">
                            {{ajaxData.sex}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="手机号：" prop="phone">
                            {{ajaxData.phone}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="渠道key：" prop="channelKey">
                            {{ajaxData.channelKey}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="渠道名称：" prop="channelName">
                            {{ajaxData.channelName}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="流水：" prop="flowAmount">
                            {{ajaxData.flowAmount}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="实收：" prop="paidAmount">
                            {{ajaxData.paidAmount}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="优惠：" prop="promotionAmount">
                            {{ajaxData.promotionAmount}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="总数量：" prop="totalNumber">
                            {{ajaxData.totalNumber}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="总重量（单位克）：" prop="totalWeight">
                            {{ajaxData.totalWeight}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="订单状态 40 已完成  30 作废  20 已退款：" prop="orderStatus">
                            {{ajaxData.orderStatus}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="订单时间，包含不限于预定时间、付款时间等,精确到分：" prop="orderTime">
                            {{ajaxData.orderTime}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="备注：" prop="remark">
                            {{ajaxData.remark}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="退款总金额：" prop="refundAmount">
                            {{ajaxData.refundAmount}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label="支付方式：" prop="payWayType">
                            {{ajaxData.payWayType}}
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="8">
                    <el-form-item label=" 0 未知   1 支付宝   2 微信：" prop="payWayTypeID">
                            {{ajaxData.payWayTypeID}}
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
                    "url": "/api/orderMaster/detail",
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
                this.$router.push({path: '/orderMasterList'});
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
