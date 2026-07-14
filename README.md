# SeedCrackerKiller per Minecraft 1.21.11

**SeedCrackerKiller 2.15.6-killer.1** è un port client Fabric per **Minecraft Java Edition 1.21.11**, costruito sulla base ufficiale di [SeedCrackerX](https://github.com/19MisterX98/SeedcrackerX) e aggiornato con diagnostica e miglioramenti di affidabilità.

> Questo progetto conserva la licenza MIT, gli autori originali **KaptainWutax** e **19MisterX98**, i collegamenti al repository originario e la compatibilità con il relativo servizio database. Non è una sostituzione ufficiale del progetto upstream.

| Componente | Versione |
|---|---:|
| Minecraft | 1.21.11 |
| Fabric Loader | 0.18.2 o successivo |
| Fabric API | 0.139.4+1.21.11 |
| Java | 21 |
| SeedCrackerKiller | 2.15.6-killer.1 |

## Miglioramenti del port

Il port parte dal tag upstream `2.15.6` (commit `4551964999b5a81acbfb0257bf21548f683498fe`), invece di tentare una conversione fragile dei sorgenti 1.21.1. Il cracking usa ora un numero adattivo di worker: almeno quattro e fino a otto, in base ai core disponibili. Il thread di orchestrazione resta separato, evitando di sottrarre un worker alla ricerca.

Le operazioni di lettura e invio al database sono asincrone e non bloccano il client Minecraft. Le cache sono thread-safe, gli errori HTTP vengono registrati in modo leggibile e una risposta malformata non cancella dati validi già caricati.

| Comando | Funzione |
|---|---|
| `/seedcracker status` | Mostra motore attivo/in pausa, cracking in corso, worker, evidenze raccolte, bit disponibili, candidati e stato database. |
| `/seedcracker cracker` | Controlla il processo di cracking, come nel progetto originale. |
| `/seedcracker data` | Gestisce e ispeziona i dati raccolti. |
| `/seedcracker finder` | Controlla i finder. |
| `/seedcracker render` | Configura la visualizzazione. |
| `/seedcracker version` | Configura la versione usata per l’analisi. |
| `/seedcracker database` | Gestisce le funzioni database originali. |

## Installazione

Installa Java 21, Fabric Loader per Minecraft 1.21.11 e le dipendenze richieste. Copia il JAR `seedcrackerkiller-2.15.6-killer.1.jar` nella cartella `mods` dell’istanza. Il mod usa un file di configurazione separato, `config/seedcrackerkiller.json`, per non sovrascrivere la configurazione di un’eventuale installazione SeedCrackerX.

## Compilazione

```bash
./gradlew clean build
```

L’artefatto rimappato viene prodotto nella cartella `build/libs`. Il JAR `-sources` contiene soltanto i sorgenti e non va installato come mod.

## Provenienza e licenza

Il codice base è [SeedCrackerX di 19MisterX98](https://github.com/19MisterX98/SeedcrackerX), tag `2.15.6`, commit `4551964999b5a81acbfb0257bf21548f683498fe`. Le modifiche specifiche di SeedCrackerKiller sono riepilogate in `CHANGELOG_SEEDCRACKERKILLER.md`. Il progetto resta distribuito secondo i termini della licenza MIT inclusa nel repository.

## Uso responsabile

Utilizzare il mod soltanto dove consentito dalle regole del server e dalla normativa applicabile. Il caricamento di seed nel database resta disattivato per impostazione predefinita e deve essere abilitato esplicitamente dall’utente.
