/** @type {import('tailwindcss').Config} */
export default {
	content: ['./src/**/*.{html,js,svelte,ts}'],
	theme: {
		extend: {
			backgroundColor: {
				background: '#11151A',
				accent: '#5C3D95'
			},
			textColor: {
				accent: '#5C3D95'
			}
		}
	},
	plugins: [require('tailwindcss-safe-area')]
};
