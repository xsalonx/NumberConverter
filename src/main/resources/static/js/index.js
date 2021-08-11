function convertRequest() {
    const notationFrom = document.getElementById("select-notation-from").value;
    const notationTo = document.getElementById("select-notation-to").value;
    const value = document.getElementById("input-value").value;

    fetch('converter/?value=' + value + '&notationFrom=' + notationFrom + '&notationTo=' + notationTo, {
        method: 'GET',
    }).then(response => response.json())
        .then(data => {
            console.log(data);
            const converterValue = document.getElementById("convertedValue");
            converterValue.innerText = data.value;
        }).catch(e => {
        console.log(e);
    })
}