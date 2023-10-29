<script>
	import { applyAction } from '$app/forms';
	import Camera from '$lib/Camera.svelte';
	import QrScan from '$lib/QRScan.svelte';
	import api from '$lib/api';
	import { getUser } from '$lib/user-service';
	import { onMount } from 'svelte';

	let user;

	const init = async () => {
		user = getUser();
		if (user) {
			const response = await api.get(`/events`);
			const json = await response.json();
			console.log(json);
		}
	};

	onMount(init);
</script>


{#if user}
	<Camera />
{:else}
	<QrScan />
{/if}
