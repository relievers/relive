<script lang="ts">
	import { onMount } from 'svelte';

	let canvas: HTMLCanvasElement | undefined;
	let video: HTMLVideoElement | undefined;
	let filePicker: HTMLInputElement | undefined;
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

	const shareImage = () => {};

	onMount(requestVideoCamera);
</script>

<main class="h-full w-full relative flex flex-col justify-end">
	<!-- svelte-ignore a11y-media-has-caption -->
	<video
		bind:this={video}
		class="h-full w-full absolute bg-black object-cover pointer-events-none -z-10"
		playsinline
	/>

	<section class="flex justify-evenly items-center">
		<div class="w-14" />
		<button on:click={takePicture} class="text-white p-3 rounded-full select-none">
			<div class="h-20 w-20 rounded-full border-4 white" />
		</button>
		<button class="rounded-full h-full" on:click={() => filePicker.click()}>
			<div class="w-14 h-14 bg-purple-900 rounded-full flex justify-center items-center">
				<div class="fa fa-upload text-white" />
			</div>
			<input bind:this={filePicker} type="file" class="hidden" />
		</button>
	</section>
</main>

<div class="w-0 h-0 overflow-hidden">
	<canvas id="canvas" height="1920" width="1080" bind:this={canvas} class="opacity-0" />
</div>
