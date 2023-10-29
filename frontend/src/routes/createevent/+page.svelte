<script>
    // key: Option, value: Duration in Minutes
    let durationValues = [
        { key: "1 Hour", value: 60},
        { key: "2 Hours", value: 120},
        { key: "3 Hours", value: 180},
        { key: "4 Hours", value: 240},
        { key: "5 Hours", value: 300},
        { key: "6 Hours", value: 360},
        { key: "12 Hours", value: 720},
        { key: "1 Day", value: 1440},
        { key: "2 Days", value: 2880},
        { key: "3 Days", value: 4320}
    ]

    let selectedDuration = durationValues[0].value;
</script>

<div class="flex-grow w-full bg-background">
    <div class="w-full min-h-full flex flex-col justify-center items-center">
        <h1 class="text-white text-4xl">Create Event</h1>
        <form class="p-6 rounded-lg w-full h-full flex flex-col">
            <div class="mb-4">
                <label for="event-name" class="block text-white text-sm font-bold mb-2">Event Name</label>
                <input type="text" id="event-name" name="event-name" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;" placeholder="PDC World Darts Championship 2024">
            </div>

            <div class="mb-4">
                <label for="event-description" class="block text-white text-sm font-bold mb-2">Event Description</label>
                <textarea id="event-description" name="event-description" class="border-none rounded-3xl w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;" placeholder="Ally Pally London"></textarea>
            </div>

            <div class="mb-4">
                <label for="start-date-time" class="block text-white text-sm font-bold mb-2">Start Date & Time</label>
                <input type="datetime-local" id="start-date-time" name="start-date-time" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;">
            </div>

            <div class="mb-4">
                <label for="duration" class="block text-white text-sm font-bold mb-2">Duration in Minutes</label>
                <select id="duration" name="duration" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31" bind:value={selectedDuration}>
                    {#each durationValues as option (option.value)}
                        <option value={option.value}>{option.key}</option>
                    {/each}
                </select>
            </div>
            
            <div class="flex justify-between mt-5">
                <div class="mt-auto flex justify-between">
                    <a class="ml-auto text-white font-bold py-3 px-4 rounded-full" style="background-color:#CC2020" href="/events">
                        <i class="fa fa-times text-2xl mx-auto"></i>
                    </a>
                </div>

                <div class="mt-auto flex justify-between">
                    <button type="submit" class="ml-auto text-white font-bold py-3 px-4 rounded-full" style="background-color:#5C3D95">
                        <i class="fa fa-check text-2xl mx-auto"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
   
</div>