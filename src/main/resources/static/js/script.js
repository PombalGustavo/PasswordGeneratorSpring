const slider = document.getElementById('passwordLength');
const sliderValue = document.getElementById('sliderValue');

slider.addEventListener('input', () => {
    sliderValue.textContent = slider.value;
});


function copy() {
      const textToCopy = document.getElementById('generatedPassword').innerText;
      navigator.clipboard.writeText(textToCopy)
        .then(() => {
          alert('Texto copiado com sucesso!');
        })
        .catch(err => {
          console.error('Erro ao copiar o texto:', err);
        });
}

function getCurrentYear() {
    const date = new Date();
    return date.getFullYear();
}

document.getElementById('currentYear').textContent = getCurrentYear();