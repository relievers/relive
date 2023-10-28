<script lang="ts">
	import { onMount } from 'svelte';

	const eventName = 'BASELHACK 2023';

	let canvas: HTMLCanvasElement | undefined;
	let video: HTMLVideoElement | undefined;
	let filePicker: HTMLInputElement | undefined;
	let loading = false;
	let imgUrl: string | undefined;
	let videoWidth = 0;
	let videoHeight = 0;

	const requestVideoCamera = async () => {
		try {
			loading = true;
			const stream = await window.navigator.mediaDevices.getUserMedia({
				audio: false,
				video: {
					facingMode: 'environment',
					aspectRatio: 1.3333333333,
					width: { min: 2560 }
				}
			});
			video.srcObject = stream;
			const settings = stream.getTracks()[0].getSettings();
			videoHeight = settings.height;
			videoWidth = settings.width;
			video.play();
			loading = false;
		} catch (error) {
			alert(error);
			console.log(error);
		}
	};

	const takePicture = () => {
		canvas.width = video.videoWidth;
		canvas.height = video.videoHeight;
		canvas.getContext('2d').drawImage(video, 0, 0, canvas.width, canvas.height);
		const img = canvas.toDataURL('image/png');
		imgUrl = img;
	};

	const pickFile = (e) => {
		const reader = new FileReader();
		reader.onload = (e) => {
			imgUrl = e.target.result.toString();
		};
		const file = filePicker.files[0];
		reader.readAsDataURL(file);
	};

	onMount(requestVideoCamera);
</script>

<main class="h-full w-full relative flex flex-col justify-between items-center">
	<!-- svelte-ignore a11y-media-has-caption -->
	{#if imgUrl}
		<div class="h-full w-full absolute -z-10">
			<img src={imgUrl} alt="My moment" class="h-full w-full flex" />
		</div>
	{:else}
		<video
			bind:this={video}
			class="h-full w-full absolute bg-black object-cover pointer-events-none -z-10"
			playsinline
		/>
	{/if}

	<section class="text-white py-5 text-center">
		<h1 class="font-bold">{eventName}</h1>
		<div class="">Capture the moment</div>
	</section>

	<section class="flex justify-evenly items-center">
		<div class="w-14" />
		<button on:click={takePicture} class="text-white p-3 rounded-full select-none">
			<div class="h-20 w-20 rounded-full border-4 white" />
		</button>
		<button class="rounded-full h-full" on:click={() => filePicker.click()}>
			<div class="w-14 h-14 bg-purple-900 rounded-full flex justify-center items-center">
				<div class="fa fa-upload text-white" />
			</div>
			<input bind:this={filePicker} type="file" class="hidden" on:change={pickFile} />
		</button>
	</section>
</main>

<div class="w-0 h-0 overflow-hidden">
	<canvas id="canvas" bind:this={canvas} class="opacity-0" />
</div>
