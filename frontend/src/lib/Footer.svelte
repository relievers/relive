<script>
    let user = { activeEvent: false };
</script>

<div class="bg-gray-900 text-white p-4">
    <div class="container mx-auto flex justify-between">
        <div class="w-1/3 text-center">
            <a class="bg-transparent hover:text-gray-500 font-bold flex flex-col items-center" href="/events">
                <i class="fa fa-calendar text-2xl mx-auto"></i>
                <span class="text-xs">Events</span>
            </a>
        </div>
        {#if user.activeEvent}
        <div class="w-1/3 text-center">
            <a class="bg-transparent hover:text-gray-500 font-bold flex flex-col items-center" href="/#">
                <i class="fa fa-camera text-2xl mx-auto"></i>
                <span class="text-xs">ReLive</span>
            </a>
        </div>
        {:else}
        <div class="w-1/3 text-center">
            <a class="bg-transparent hover:text-gray-500 font-bold flex flex-col items-center" href="#">
                <i class="fa fa-qrcode text-2xl mx-auto"></i>
                <span class="text-xs">Scan QR Code</span>
            </a>
        </div>
        {/if}
        
        <div class="w-1/3 text-center">
            <a class="bg-transparent hover:text-gray-500 font-bold flex flex-col items-center" href="/settings">
                <i class="fa fa-user-circle-o text-2xl mx-auto"></i>
                <span class="text-xs">Account</span>
            </a>
        </div>
    </div>
</div>