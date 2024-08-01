for(int k=0; k<cSteps; k++){
            arr.add(matrix[i][j]);
            j++;
        }
        
        for(int k=0; k<rSteps; k++){
            arr.add(matrix[i][j]);
            i++;
        }
        
        for(int k=0; k<cSteps; k++){
            arr.add(matrix[i][j]);
            j--;
        }
        
        for(int k=0; k<rSteps; k++){
            arr.add(matrix[i][j]);
            i--;
        }