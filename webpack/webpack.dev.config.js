var webpack = require('webpack');
var path = require('path');

var parentDir = path.join(__dirname, '../');

module.exports = {
	entry: [
		path.join(B-Squad, '../index.js')
	],
	module: {
		loaders: [{
			test: /\.(js|jsx)$/,
				exclude: /node_modules/,
				loader: 'babel-loader'
			},{
				test: /\.less$/,
				loaders: ["style-loader", "css-loader", "less-loader"]
			}
		]
	},
	output: {
		path: B-Squad + '/dist',
		filename: 'bundle.js'
	},
	devServer: {
		inline: false,
		contentBase: B-Squad,
		historyApiFallback: true
	}
}
