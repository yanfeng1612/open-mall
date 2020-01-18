module.exports = {
    // baseUrl: './',
    assetsDir: 'static',
    productionSourceMap: false,
    devServer: {
        proxy: {
            '/api':{
                // target:'http://jsonplaceholder.typicode.com',
                target:'http://localhost:9000/',
                changeOrigin:true,
                pathRewrite:{
                    '/api':''
                }
            }
        }
    }
}