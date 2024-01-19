import ApiChequeos from '../model/ApiChequeos';

const ChequeosViewModel = {

    getChequeos: async () => {
        const status = await ApiChequeos.getChequeos();
        return status;
    },

};

export default ChequeosViewModel;