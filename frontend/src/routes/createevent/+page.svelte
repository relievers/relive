<div class="flex-grow w-full bg-background">
    <div class="w-full h-full flex flex-col justify-center items-center">
        <h1 class="text-white text-4xl">Create Event</h1>
        <form class="p-6 rounded-lg w-full h-full flex flex-col">
            <div class="mb-4">
                <label for="event-name" class="block text-white text-sm font-bold mb-2">Event Name</label>
                <input type="text" id="event-name" name="event-name" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;">
            </div>

            <div class="mb-4">
                <label for="event-description" class="block text-white text-sm font-bold mb-2">Event Description</label>
                <textarea id="event-description" name="event-description" class="border-none rounded-3xl w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;"></textarea>
            </div>

            <div class="mb-4">
                <label for="start-date-time" class="block text-white text-sm font-bold mb-2">Start Date & Time</label>
                <input type="datetime-local" id="start-date-time" name="start-date-time" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;">
            </div>

            <div class="mb-4">
                <label for="duration" class="block text-white text-sm font-bold mb-2">Duration in Minutes</label>
                <input type="number" id="duration" name="duration" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;">
            </div>

            <div class="mt-auto flex justify-between">
                <button type="submit" class="ml-auto text-white font-bold py-3 px-4 rounded-full" style="background-color:#5C3D95">
                    <i class="fa fa-check text-2xl mx-auto"></i>
                </button>
            </div>
        </form>
    </div>
   
</div>