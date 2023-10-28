<script lang="ts">
	import { onMount } from 'svelte';

	let videoSource = null;
	let loading = false;

	const requestVideoCamera = async () => {
		try {
			loading = true;
			const stream = await window.navigator.mediaDevices.getUserMedia({
				preferCurrentTab: true,
				video: {
					facingMode: 'environment',
					height: 1920
				}
			});
			videoSource.srcObject = stream;
			videoSource.play();
			loading = false;
		} catch (error) {
			alert(error);
			console.log(error);
		}
	};

	onMount(requestVideoCamera);
</script>

<main class="h-full relative">
	<!-- svelte-ignore a11y-media-has-caption -->
	<video
		bind:this={videoSource}
		class="h-full w-full bg-black object-cover pointer-events-none"
		playsinline
	/>
	<button
		on:click={requestVideoCamera}
		class="absolute bottom-10 text-white z-10 bg-gray-800 left-1/2 -translate-x-1/2 p-3 rounded"
	>
		Enable Camera
	</button>
</main>
