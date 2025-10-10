from ortools.linear_solver import pywraplp

def solucao():
    solver = pywraplp.Solver.CreateSolver('SCIP')
    
    M = ['m1', 'm2', 'm3']  
    P = ['p1', 'p2', 'p3']  
    A = ['arroz', 'feijao', 'alface']  
    N = ['calorias', 'proteinas']  
    
    Qm = {'m1': 100, 'm2': 150, 'm3': 70} 
    Rn = {'calorias': 2000, 'proteinas': 50}  
    Ona = {  
        ('arroz', 'calorias'): 3.5,
        ('arroz', 'proteinas'): 0.7,
        ('feijao', 'calorias'): 3.0,
        ('feijao', 'proteinas'): 2.0,
        ('alface', 'calorias'): 3.0,
        ('alface', 'proteinas'): 0.0
    }
    Dap = {  
        ('p1', 'arroz'): 50,
        ('p1', 'feijao'): 30,
        ('p1', 'alface'): 20,
        ('p2', 'arroz'): 40,
        ('p2', 'feijao'): 35,
        ('p2', 'alface'): 15,
        ('p3', 'arroz'): 30,
        ('p3', 'feijao'): 25,
        ('p3', 'alface'): 10,
    }
    Cap = {  
        ('p1', 'arroz'): 1000,
        ('p1', 'feijao'): 1200,
        ('p1', 'alface'): 600,
        ('p2', 'arroz'): 950,
        ('p2', 'feijao'): 1100,
        ('p2', 'alface'): 500,
        ('p3', 'arroz'): 750,
        ('p3', 'feijao'): 1000,
        ('p3', 'alface'): 700,
    }
    Tpm = {  
        ('p1', 'm1'): 50,
        ('p1', 'm2'): 70,
        ('p1', 'm3'): 65,
        ('p2', 'm1'): 60,
        ('p2', 'm2'): 55,
        ('p2', 'm3'): 40,
        ('p3', 'm1'): 38,
        ('p3', 'm2'): 57,
        ('p3', 'm3'): 78
    }
    
    damp = {}
    for a in A:
        for p in P:
            for m in M:
                damp[(a, p, m)] = solver.NumVar(0, solver.infinity(), f'd_{a}_{p}_{m}')
    
    
    for p in P:
        for a in A:
            constraint = solver.Constraint(0, Dap[(p, a)])
            for m in M:
                constraint.SetCoefficient(damp[(a, p, m)], 1)
    
    for m in M:
        for n in N:
            constraint = solver.Constraint(
                Qm[m] * Rn[n],  
                Qm[m] * Rn[n]   
            )
            for a in A:
                for p in P:
                    constraint.SetCoefficient(
                        damp[(a, p, m)], 
                        Ona[(a, n)] * 1000  
                    )
    objective = solver.Objective()
    for a in A:
        for p in P:
            for m in M:
                objective.SetCoefficient(
                    damp[(a, p, m)],(Cap[(p, a)] + Tpm[(p, m)])  
                )
    objective.SetMinimization()
    
    status = solver.Solve()
    
    if status == pywraplp.Solver.OPTIMAL:
        print('Solução ótima encontrada!')
        print(f'Custo total mínimo: R${objective.Value():,.2f}\n')
        
        print('Alocações:')
        for a in A:
            for p in P:
                for m in M:
                    val = damp[(a, p, m)].solution_value()
                    if val > 0:
                        print(f'{val:.2f} ton de {a} de {p} para {m}')
        
        print('\nVerificação nutricional:')
        for m in M:
            print(f'\nMunicípio {m} (Qm = {Qm[m]} cestas):')
            for n in N:
                total_nut = sum(
                    damp[(a, p, m)].solution_value() * Ona[(a, n)] * 1000
                    for a in A for p in P
                )
                print(f'- {n}: {total_nut:.2f}g (requerido: {Qm[m]*Rn[n]}g)')
    else:
        print('Não foi encontrada solução ótima.')

solucao()