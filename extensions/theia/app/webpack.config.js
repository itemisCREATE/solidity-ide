// @ts-check
const path = require('path');
const webpack = require('webpack');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CircularDependencyPlugin = require('circular-dependency-plugin');

const outputPath = path.resolve(__dirname, 'lib');
const development = process.env.NODE_ENV === 'development';

const monacoEditorPath = development ? '/mnt/c/programmieren/yakindu/solidity-ide/extensions/theia/node_modules/monaco-editor-core/dev/vs' : '/mnt/c/programmieren/yakindu/solidity-ide/extensions/theia/node_modules/monaco-editor-core/min/vs';
const monacoLanguagesPath = '/mnt/c/programmieren/yakindu/solidity-ide/extensions/theia/node_modules/monaco-languages/release';
const monacoCssLanguagePath = '/mnt/c/programmieren/yakindu/solidity-ide/extensions/theia/node_modules/monaco-css/release/min';
const monacoJsonLanguagePath = '/mnt/c/programmieren/yakindu/solidity-ide/extensions/theia/node_modules/monaco-json/release/min';
const monacoHtmlLanguagePath = '/mnt/c/programmieren/yakindu/solidity-ide/extensions/theia/node_modules/monaco-html/release/min';

module.exports = {
    entry: path.resolve(__dirname, 'src-gen/frontend/index.js'),
    output: {
        filename: 'bundle.js',
        path: outputPath
    },
    target: 'web',
    node: {
        fs: 'empty',
        child_process: 'empty',
        net: 'empty',
        crypto: 'empty'
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                exclude: /\.useable\.css$/,
                loader: 'style-loader!css-loader'
            },
            {
                test: /\.useable\.css$/,
                loader: 'style-loader/useable!css-loader'
            },
            {
                test: /\.(ttf|eot|svg)(\?v=\d+\.\d+\.\d+)?$/,
                loader: 'url-loader?limit=10000&mimetype=image/svg+xml'
            },
            {
                test: /.(jpg|png|gif)$/,
                loader: 'file-loader',
                options: {
                    name: '[path][name].[hash].[ext]',
                }
            },
            {
                // see https://github.com/theia-ide/theia/issues/556
                test: /source-map-support/,
                loader: 'ignore-loader'
            },
            {
                test: /\.js$/,
                enforce: 'pre',
                loader: 'source-map-loader',
                exclude: /jsonc-parser/
            },
            {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: "url-loader?limit=10000&mimetype=application/font-woff"
            },
            {
                test: /node_modules[\\|/](vscode-languageserver-types|vscode-uri|jsonc-parser)/,
                use: { loader: 'umd-compat-loader' }
            }
        ]
    },
    resolve: {
        extensions: ['.js'],
        alias: {
            'vs': path.resolve(outputPath, monacoEditorPath)
        }
    },
    devtool: 'source-map',
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new CopyWebpackPlugin([
            {
                from: monacoEditorPath,
                to: 'vs'
            },
            {
                from: monacoLanguagesPath,
                to: 'vs/basic-languages'
            },
            {
                from: monacoCssLanguagePath,
                to: 'vs/language/css'
            },
            {
                from: monacoJsonLanguagePath,
                to: 'vs/language/json'
            },
            {
                from: monacoHtmlLanguagePath,
                to: 'vs/language/html'
            }
        ]),
        new CircularDependencyPlugin({
            exclude: /(node_modules|examples)\/./,
            failOnError: false // https://github.com/nodejs/readable-stream/issues/280#issuecomment-297076462
        })
    ],
    stats: {
        warnings: true
    }
};