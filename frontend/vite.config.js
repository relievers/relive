// vite.config.js
import basicSSL from '@vitejs/plugin-basic-ssl';
import { sveltekit } from '@sveltejs/kit/vite';

/** @type {import('vite').UserConfig} */
const config = {
	plugins: [sveltekit()],
	server: {
		https: false
	}
};

export default config;
