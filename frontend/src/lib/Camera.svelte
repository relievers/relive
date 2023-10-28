<script lang="ts">
	import { onMount } from 'svelte';

	let canvas: HTMLCanvasElement | undefined;
	let video: HTMLVideoElement | undefined;
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
			video.srcObject = stream;
			video.play();
			loading = false;
		} catch (error) {
			alert(error);
			console.log(error);
		}
	};

	const takePicture = () => {
		console.log(video.srcObject);
		const height = 1920;
		const width = 1080;
		canvas.getContext('2d').drawImage(video, 0, 0, width, height, 0, 0, width, height);
		const img = canvas.toDataURL('image/png');
	};

	onMount(requestVideoCamera);
</script>

<main class="h-full w-full relative">
	<!-- svelte-ignore a11y-media-has-caption -->
	<video
		bind:this={video}
		class="h-full w-full absolute bg-black object-cover pointer-events-none"
		playsinline
	/>
	<button
		on:click={takePicture}
		class="absolute bottom-10 text-white z-10 left-1/2 -translate-x-1/2 p-3 rounded-full select-none"
	>
		<div class="h-20 w-20 rounded-full border-4 white" />
	</button>
</main>

<div class="w-0 h-0 overflow-hidden">
	<canvas id="canvas" height="1920" width="1080" bind:this={canvas} class="opacity-0" />
</div>