// vite.config.js
import basicSSL from '@vitejs/plugin-basic-ssl';
import { sveltekit } from '@sveltejs/kit/vite';

/** @type {import('vite').UserConfig} */
const config = {
	plugins: [sveltekit(), basicSSL()],
	server: {
		https: true
	}
};

export default config;
