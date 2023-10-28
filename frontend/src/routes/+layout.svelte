<script>
	import '../app.css';
	import Footer from '$lib/Footer.svelte';
</script>

<div class="h-full flex flex-col">
	<slot />
	<Footer />
</div>
