<script>
	import { page } from '$app/stores';

	let user = { activeEvent: false };
</script>

<div class="bg-background text-gray-400 p-4">
	<div class="container mx-auto flex justify-between">
		<div class="w-1/3 text-center">
			<a
				class="bg-transparent font-bold flex flex-col items-center"
				class:text-white={$page.url.pathname === '/events'}
				href="/events"
			>
				<i class="fa fa-calendar text-2xl mx-auto" />
				<span class="text-xs">Events</span>
			</a>
		</div>
		{#if !user.activeEvent}
			<div class="w-1/3 text-center">
				<a
					class="bg-transparent font-bold flex flex-col items-center"
					class:text-white={$page.url.pathname === '/'}
					href="/"
				>
					<i class="fa fa-camera text-2xl mx-auto" />
					<span class="text-xs">ReLive</span>
				</a>
			</div>
		{:else}
			<div class="w-1/3 text-center">
				<a
					class="bg-transparent font-bold flex flex-col items-center"
					class:text-white={$page.url.pathname === '/'}
					href="/"
				>
					<i class="fa fa-qrcode text-2xl mx-auto" />
					<span class="text-xs">Scan QR Code</span>
				</a>
			</div>
		{/if}

		<div class="w-1/3 text-center">
			<a
				class="bg-transparent font-bold flex flex-col items-center"
                class:text-white={$page.url.pathname === '/settings'}
				href="/settings"
			>
				<i
					class="fa fa-user-circle-o text-2xl mx-auto"
				/>
				<span class="text-xs">Account</span>
			</a>
		</div>
	</div>
</div>
