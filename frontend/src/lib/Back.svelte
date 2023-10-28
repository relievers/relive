<script>
    function goBack() {
        history.back();
    }
</script>

<div class="bg-transparent absolute text-white top-16 left-8">
    <!-- angle-left -->
    <button on:click={goBack} class="btn w-8 h-8">
        <i class="fa fa-angle-left text-2xl mx-auto"/>
    </button>
</div>
