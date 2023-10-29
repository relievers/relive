<script>
	import '../app.css';
	import Footer from '$lib/Footer.svelte';
	import { page } from '$app/stores';
	import { getUser } from '$lib/user-service';
	import { onMount } from 'svelte';

	const mainPages = ['/', '/settings', '/events'];

	$: isMainPage = mainPages.find((value) => $page.url.pathname == value);

	let user;

	onMount(() => user = getUser());
</script>

<div class="h-full flex flex-col">
	<slot />

	{#if isMainPage && user}
		<Footer />
	{/if}
</div>s
