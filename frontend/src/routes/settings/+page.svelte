<script>
    let username = "Hubertus"; // TODO: load username
</script>

<div class="flex-grow w-full">
    <div class="bg-background min-h-full flex flex-col justify-center items-center">
        <div class="rounded-full overflow-hidden w-64 h-64 mb-10 mt-10">
            <!-- Currently placeholder Profile Picture -->
            <img src="emptyProfilePicture.png" alt="{username}' Profile Picture" class="w-full h-full object-cover" />
          </div>
        <h1 class="text-white text-4xl">Hello {username}</h1>
        
        <form class="p-6 rounded-lg w-full h-full flex flex-col">
            <div class="mb-4">
                <label for="change-username" class="block text-white text-sm font-bold mb-2">Change your name</label>
                <input type="text" id="event-name" name="event-name" placeholder="{username}" class="border-none rounded-full w-full py-2 px-3 text-white bg-gray-200 focus:outline-none focus:border-blue-500" style="background-color: #282A31;">
            </div>

            
            <div class="mt-auto flex justify-between">
                <button type="submit" class="ml-auto text-white font-bold py-3 px-4 rounded-full" style="background-color:#5C3D95">
                    <i class="fa fa-check text-2xl mx-auto"></i>
                </button>
            </div>
        </form>
    </div>
</div>