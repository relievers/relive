<script>
	import '../app.css';
	import Footer from '$lib/Footer.svelte';
	import { page } from '$app/stores';

	const mainPages = ['/', '/settings', '/events'];

	$: isMainPage = mainPages.find((value) => $page.url.pathname == value);
</script>

<div class="h-full flex flex-col">
	<slot />

	{#if isMainPage}
		<Footer />
	{/if}
</div>s
