<script lang="ts">
	import { onMount } from 'svelte';
    import { Html5Qrcode } from 'html5-qrcode';
	import { goto } from '$app/navigation';


    let html5Qrcode

    onMount(init)

    function init() {
        html5Qrcode = new Html5Qrcode('reader');
        html5Qrcode.start(
            { facingMode: 'environment' },
            {
                fps: 10,
                qrbox: { width: 250, height: 250 },
				aspectRatio: 0.5625
            },
            onScanSuccess,
            onScanFailure
        );
    }

    async function onScanSuccess(decodedText, decodedResult) {
		try {
			const url = new URL(decodedText);
			if (url.host != window.location.host) return;
			const path = url.pathname;
			if (!path.startsWith('/events/join/')) return;
			const eventId = path.substring(12);
        	html5Qrcode.stop();
			goto(path);
		} catch {
			// ignore, not a URL that was scanned
			alert('error url ')
		}
		
    }

    function onScanFailure(error) {
        console.warn(`Code scan error = ${error}`)
    }

	let canvas: HTMLCanvasElement | undefined;
	let video: HTMLVideoElement | undefined;
	let loading = false;
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

	onMount(requestVideoCamera);
</script>

<style>
	reader {
		position: absolute !important;
	}

</style>

<main class="h-full w-full relative flex flex-col justify-between items-center">
	<reader id="reader" class="absolute w-full h-full bg-black object-cover pointer-events-none -z-20" />

	<!-- svelte-ignore a11y-media-has-caption -->
	<!-- <video
		bind:this={video}
		class="h-full w-full absolute bg-black object-cover pointer-events-none -z-10"
		playsinline
	/>

	<section class="text-white py-8 text-center">
		<h1 class="font-bold text-4xl">ReLive</h1>
		<div class="">Scan QR code to<br>join an event</div>
	</section>


    <section class="w-56 h-56 p-4 relative">
        <img src="/images/qr-code-placeholder.png" alt="QR code" class="opacity-25 object-cover"/>
        <div class="absolute border-t-2 border-l-2 top-5 left-5 w-10 h-10 border-gray-400"></div>
        <div class="absolute border-t-2 border-r-2 top-5 right-5 w-10 h-10 border-gray-400"></div>
        <div class="absolute border-b-2 border-l-2 bottom-5 left-5 w-10 h-10 border-gray-400"></div>
        <div class="absolute border-b-2 border-r-2 bottom-5 right-5 w-10 h-10 border-gray-400"></div>
    </section>

    <section class="flex flex-row w-full justify-end my-8">
        <a href="/events/create" type="submit" class="flex justify-center items-center ml-auto text-white font-bold w-16 h-16 rounded-full mr-8 bg-accent">
            <i class="fa fa-plus text-2xl mx-auto"></i>
        </a>
    </section> -->

</main>

<div class="w-0 h-0 overflow-hidden">
	<canvas id="canvas" bind:this={canvas} class="opacity-0" />
</div>
